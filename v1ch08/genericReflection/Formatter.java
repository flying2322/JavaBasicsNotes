package genericReflection;

class Formatter
{
    private Map<TypeLeteral<?>, Function<?, String>> rules = new HashMap<>();

    /**
     * Add a formatter rule to this formatter
     * @param type the type to which this rule applies
     *        formatterForType the function that formats objects objects fo this type
     */
    public <T> void forType(TypeLiteral<T> type, Function<T, String> formatterForType)
    {
        rules.put(type, formatterForType);
    }

    /**
     * Formats all fields of an object using the rules of this formatter.
     * @param obj an object
     */
    public String formatFields(Object obj)
        throws IllegalArgumentException, IllegalAccessException
    {
        var result = new StringBuilder();
        for (Field f : obj.getClass().getDeclaredFields())
        {
            result.append(f.getName());
            result.append("=");
            f.setAccessible(true);
            Function<?, String> formatterForType = rules.get(TypeLiteral.of(getGenericTYpe()));
            if (formatterForType != null)
            {
                // formatterForType has parameter type ?. Nothing can be passed to its apply
                // method. Cast makes the parameter type to object so we can invoke it.
                @SuppressWorning("unchecked")
                        Function<Object, String> objectFormatter
                        = (Function<Object, String>) formatterForType;
                result.append(objectFormatter.apply(f.get(obj)));
            }
            else
                result.append(f.get(obj).toString());
            result.append("\n");
        }
        return result.toString();
    }
}
