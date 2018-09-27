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
		Connection con = getConnection();//Ŀ�ؼ� ��ü�� ������ �Ѵ�
		DogDao dogDao = new DogDao(con);//DogdaoŬ���� �����ؾ��Ѵ�. dao�� ��Ű�� �����ϰ� ����
		ArrayList<Dog> dogList = dogDao.getDogList(); //Dogdao.java ������ ���Ŀ� ���� ����
		close(con);		
		return dogList;
	}
	

}
