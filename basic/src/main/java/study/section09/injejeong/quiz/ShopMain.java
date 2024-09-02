package study.section09.injejeong.quiz;

import study.week2.section09.injejeong.quiz.Album;
import study.week2.section09.injejeong.quiz.Book;
import study.week2.section09.injejeong.quiz.Movie;

public class ShopMain {
    public static void main(String[] args) {
        // 상속 관계 상품
        study.week2.section09.injejeong.quiz.Book book = new Book("JAVA", 10000, "han", "12345");
        study.week2.section09.injejeong.quiz.Album album = new Album("앨범1", 15000, "seo");
        study.week2.section09.injejeong.quiz.Movie movie = new Movie("영화1", 18000, "감독1", "배우1");
        book.print();
        album.print();
        movie.print();
        int sum = book.getPrice() + album.getPrice() + movie.getPrice();
        System.out.println("상품 가격의 합: " + sum);
    }
}
