package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.VO.BookVO;

@Mapper
public interface BookRepository {

	@Delete("""
			TRUNCATE TABLE book;
			""")
	void truncateTable();

	@Insert("""
			INSERT INTO book
				SET title = #{bookName}
					, author = #{author}
					, storeId = #{storeId}
			""")
	void makeBook(String bookName, String author, int storeId);

	@Select("""
			SELECT *
				FROM book;
			""")
	List<BookVO> showBooksTitle();

	@Select("""
			SELECT b.title
				FROM book b
				INNER JOIN bookStore bs
				ON bs.id = b.storeId
				WHERE bs.id = 1;
			""")
	List<BookVO> showBooksTitleByKorea();

	@Delete("""
			DELETE FROM book
			WHERE author = #{author}
			""")
	void deleteBookByAuthor(String author);

}
