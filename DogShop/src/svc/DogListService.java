package svc;

import static util.DbUtil.close;
import static util.DbUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DogDao;
import vo.Dog;

public class DogListService {

	public ArrayList<Dog> getDogList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();//커넥션 개체를 만들어야 한다
		DogDao dogDao = new DogDao(con);//Dogdao클래스 생성해야한다. dao로 패키지 지정하고 설정
		ArrayList<Dog> dogList = dogDao.getDogList(); //Dogdao.java 생성한 이후에 문장 생성
		close(con);		
		return dogList;
	}
	

}
