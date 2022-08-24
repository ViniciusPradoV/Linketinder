package services

class PrintAndGetService {

     static String printAndGet(String question){
        println(question)
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }
}
