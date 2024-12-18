public class Store {
    private Marriage[] marriageGuests;
    private int total = 0;

    public Store(int numbersGroup) {
        marriageGuests = new Marriage[numbersGroup];
    }

    private boolean isFull(){
        return total == marriageGuests.length;
    }
    private boolean isEmpty(){
        return total == 0;
    }
    public boolean add(Marriage marriage){
        if(isFull()){
            return false;
        }
        else{
            marriageGuests[total] = marriage;
            total++;
            return true;
        }
    }
    public String listGuests() {
        if (isEmpty()) {
            return "No guests";
        } else {
            String listGuests = "";
            for (int i = 0; i < total; i++) {
                listGuests += i + ":" + marriageGuests[i] + "\n";
            }
            return listGuests;
        }
    }
}
