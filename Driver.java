import java.util.Scanner;

public class Driver {
    private Scanner input = new Scanner(System.in);
    private Store store;

    private String groomName;
    private String brideName;
    private String weddingDate;

    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.inputWeddingInfo(); // enter the basic introduction about wedding first
        driver.verifyPasswordAndProcess();
    }

    public void inputWeddingInfo() {
        System.out.print("Enter the groom's name:");
        groomName = input.nextLine();
        System.out.print("Enter the bride's name:");
        brideName = input.nextLine();
        System.out.print("Enter the predicted wedding date(example:2024-12-31): ");
        weddingDate = input.nextLine();
        System.out.println("Congratulations on your happy wedding!");
        System.out.println("结发为夫妻，恩爱两不疑");
    }
    public void verifyPasswordAndProcess() {
        int attemptLimit = 3;
        int attemptCount = 0;

        while (attemptCount < attemptLimit) {
            System.out.print("请输入密码以继续操作: ");
            String enteredPassword = input.nextLine();

            if (enteredPassword.equals(PASSWORD)) {
                processInvitation();
                printGroup();
                return; // 密码正确，执行完后续操作后直接返回
            } else {
                attemptCount++;
                if (attemptCount < attemptLimit) {
                    System.out.println("密码错误，请重新输入，你还有 " + (attemptLimit - attemptCount) + " 次机会。");
                } else {
                    System.out.println("密码错误次数已达上限，无法进行后续操作，请重新运行程序并输入正确密码。");
                }
            }
        }
    }

    public void processInvitation() {
        input.nextLine();//leave one blank line to maintain aesthetics
        System.out.print("Enter the numbers the groups you want to invite: ");
        int numbersGroup = input.nextInt();
        store = new Store(numbersGroup);
        for (int i = 0; i < numbersGroup; i++) {
            addGroup();
        }
    }

    public void addGroup() {
        input.nextLine();

        System.out.print("Enter the host's name of the group: ");
        String name = input.nextLine();
        System.out.print("Enter the code of the group: ");
        int code = input.nextInt();
        System.out.print("Enter the number of the group:");
        int number = input.nextInt();
        System.out.print("Is the group added into the current list(y/n): ");
        char currentList = input.next().charAt(0);

        boolean inCurrentList = false;// 使用switch语句来设置inCurrentList的值
        switch (currentList) {
            case 'y':
            case 'Y':
                inCurrentList = true;
                break;
            case 'n':
            case 'N':
                inCurrentList = false;
                break;
            default:
                System.out.println("输入无效，请输入y或n。");
                addGroup();
        }

        boolean isAdded = store.add(new Marriage(name,number, code, inCurrentList));
        if (isAdded) {
            System.out.println("The group " + name + " 's family has added into the current list ");
        }
        else {
            System.out.println("The group " + name + " 's family is not added into the current list");
        }
        System.out.println();
    }

    public void printGroup() {
        System.out.println(store.listGuests());
    }
}
