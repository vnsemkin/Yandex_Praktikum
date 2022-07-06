public class Praktikum {
    public static void main(String[] args) {
        for (int i = 1; i < 21; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("Яндекс.Практикум");
            }else if (i % 5 == 0){
                System.out.println("Практикум");
            }else if (i % 3 == 0){
                System.out.println("Яндекс");
            }else{
                System.out.println(i);
            } // Решение должно быть в теле цикла
        }
    }
}