package com.netflix.movie;
import com.netflix.movie.controller.NetflixController;
import com.netflix.movie.model.Netflix;
import com.netflix.movie.repository.NetflixRepository;

import java.util.*;

public class Application {




    public static void main(String[] args) {
        NetflixRepository netflixRepository = new NetflixRepository();
        NetflixController netflixController = new NetflixController();
        netflixRepository.getData();
        System.out.println("========================================");
        List<Netflix> netflixList = netflixRepository.netflixList;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                menu();
                int ch = scanner.nextInt();
                scanner.nextLine();
                switch (ch){
                    case 1:
                        System.out.println("Phim sau khi sắp xếp");
                        Collections.sort(netflixList, new Comparator<Netflix>() {
                            @Override
                            public int compare(Netflix o1, Netflix o2) {
                                return o1.getTitle().compareTo(o2.getTitle());
                            }
                        });
                        printResul(netflixList);
                        break;
                    case 2:
                        System.out.println("Nhập tên phim cần tìm: ");
                        String name =scanner.nextLine();
                        netflixController.searchMovieByName(netflixList,name);
                        break;
                    case 3:
                        System.out.println("Nhập tên phim cần tìm: ");
                        String category =scanner.nextLine();
                        netflixController.searchMovieByCategory(netflixList,category);
                        break;
                    case 4:
                        System.out.println("Nhập tên phim cần tìm: ");
                        String language =scanner.nextLine();
                        netflixController.searchMovieByLanguage(netflixList,language);
                        break;
                    case 5:
                        netflixController.countMovieByCategory();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
        public static void printResul(List<Netflix> list){
            for (Netflix netflix: list){
                System.out.println(netflix);
            }
        }
        public static void menu () {
            System.out.println("Chức năng: ");
            System.out.println("1. Sắp xếp theo title phim");
            System.out.println("2. Tìm kiếm theo title");
            System.out.println("3. Tìm kiếm theo category");
            System.out.println("4. Tìm kiếm theo language");
            System.out.println("5. Thống kê phim theo category");
            System.out.println("6. Kết thúc chương trình");
        }

}