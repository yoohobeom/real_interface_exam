package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.VO.BookStoreVO;

@Mapper
public interface BookStoreRepository {

	@Delete("""
			TRUNCATE TABLE bookStore;
			""")
	void truncateTable();

	@Insert("""
			INSERT INTO bookStore
				SET `name` = #{storeName};
			""")
	void makeStore(String storeName);

	@Select("""
			SELECT *
				FROM bookStore;
			""")
	List<BookStoreVO> showBookStores();

	@Update("""
			UPDATE bookStore
				SET `name` = #{name}
				WHERE id = #{storeId};
			""")
	void modifyStoreName(int storeId, String name);

}
