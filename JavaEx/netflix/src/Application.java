import controller.NetflixController;
import model.Netflix;
import repository.NetflixRespository;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        NetflixRespository netflixRespository = new NetflixRespository();
        NetflixController netflixController = new NetflixController();
        netflixRespository.getData();
        System.out.println("==========================================");

        Scanner sc = new Scanner(System.in);
        List<Netflix> netflixList = netflixRespository.netflixList;

        while (true){
            menu();
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1:
                    System.out.println("Phim sau khi sắp xếp");
                    Collections.sort(netflixList, new Comparator<Netflix>() {
                        @Override
                        public int compare(Netflix o1, Netflix o2) {
                            return o1.getTitle().compareTo(o2.getTitle());
                        }
                    });
                    printResult(netflixList);
                    break;
                case 2:
                    System.out.println("Nhập tên phim cần tìm: ");
                    String name = sc.nextLine();
                    netflixController.searchMovieByName(netflixList,name);
                    break;
                case 3:
                    System.out.println("Nhập thể loại phim cần tìm: ");
                    String category = sc.nextLine();
                    netflixController.searchMovieByCategory(netflixList,category);
                    break;
                case 4:
                    System.out.println("Nhập tên language cần tìm: ");
                    String language = sc.nextLine();
                    netflixController.searchMovieByLanguage(netflixList,language);
                    break;
                case 5:

                    break;
                case 6:
                    break;
            }
        }
    }
    public static void printResult(List<Netflix> list){
        for (Netflix netflix : list){
            System.out.println(netflix);
        }
    }
    public static void menu(){
        System.out.println("Chức năng");
        System.out.println("1. Sắp xếp theo phim");
        System.out.println("2. Tìm kiếm theo title");
        System.out.println("3. Tìm kiếm theo category");
        System.out.println("4. Tìm kiếm theo language");
        System.out.println("5. Thống kê phim theo category");
        System.out.println("6. Thoát chương trình");
    }


}
