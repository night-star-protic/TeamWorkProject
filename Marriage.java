public class Marriage {
    private String name;
    private int number;
    private int code;
    private boolean inCurrentList;

    public Marriage(String name, int number, int code, boolean inCurrentList) {
        this.name = name;
        this.number = number;
        this.code = code;
        this.inCurrentList = inCurrentList;
    }

    @Override
    public String toString() {
        return "Guest's name：" + name + ", The number of the group：" + number + ", The code of the group：" + code + ", If it is in the current line：" + inCurrentList;
    }

    // 构造方法、Getter和Setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isInCurrentList() {
        return inCurrentList;
    }

    public void setInCurrentList(boolean inCurrentList) {
        this.inCurrentList = inCurrentList;
    }
}
