import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // 创建File对象
        File file = new File("a.txt");

        // 检查文件是否存在
        if (file.exists()) {
            System.out.println("文件存在!");
        } else {
            System.out.println("文件不存在!");
        }

        // 获取文件信息
        String fileName = file.getName();
        String absolutePath = file.getAbsolutePath();
        String parentDirectory = file.getParent();

        System.out.println("文件名：" + fileName);
        System.out.println("绝对路径：" + absolutePath);
        System.out.println("父目录：" + parentDirectory);

        // 检查是文件还是目录
        if (file.isFile()) {
            System.out.println("这是一个文件!");
        } else if (file.isDirectory()) {
            System.out.println("这是一个目录!");
        }

        // 列出目录下的文件
        File directory = new File("path/to/your/directory");
        File[] files = directory.listFiles();

        if (files != null) {
            System.out.println("目录下的文件列表：");
            for (File f : files) {
                System.out.println(f.getName());
            }
        }

        // 创建文件
        File newFile = new File("path/to/your/newfile.txt");

        try {
            if (newFile.createNewFile()) {
                System.out.println("文件创建成功!");
            } else {
                System.out.println("文件已经存在!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 删除文件
        if (newFile.delete()) {
            System.out.println("文件删除成功!");
        } else {
            System.out.println("文件删除失败。");
        }
    }
}
