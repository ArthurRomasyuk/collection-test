package list_test;

public class CustomListTest {
    public static void main(String[] args) {
        CustomList customList = new CustomList();
        for (int i = 0; i < 5; i++) {
            customList.add(String.valueOf(i));
        }

        System.out.println(customList);
        customList.add(3, "new Value");
        System.out.println(customList);

        System.out.println("size=" + customList.getSize());
        //customList.add(6, "new Value");
        customList.remove(0);
        System.out.println(customList);
        System.out.println(customList.get(0));
        customList.trimToSize();
        System.out.println(customList);
    }


}
