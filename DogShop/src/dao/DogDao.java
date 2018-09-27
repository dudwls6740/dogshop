package dao; //현재 dog.sql -> DOglistServlet
import java.sql.*; //DB작업할것이니 sql임포트
import java.util.ArrayList;
import java.util.List;
import vo.Dog;
import static util.DbUtil.*;

public class DogDao {
	private Connection con = null; //얘 부터 만들고 alt + shift + s 만들고 genarate constructor using fields
	public DogDao(Connection con) {
		super();
		this.con = con;
	}
	public List<Dog> getDogs() {
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<Dog> dogs = null;

		try{
			String sql="select * from dog";
			pstmt = con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			dogs = new ArrayList<Dog>(); //ArrayList??? 객체를 담는다???
			Dog dog = null;
			while(rs.next()){
				dog = new Dog();
				dog.setId(rs.getInt("id"));
				dog.setKind(rs.getString("kind"));
				dog.setContent(rs.getString("content"));
				dog.setPrice(rs.getInt("price"));
				dog.setWeight(rs.getInt("weight"));
				dog.setHeight(rs.getInt("height"));
				dog.setImage(rs.getString("image"));
				dog.setCountry(rs.getString("country"));
				dog.setReadcount(rs.getInt("readcount"));
				dogs.add(dog);//dog에 저장
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(rs);
		}
		return dogs;
	}
	public Dog getDog(String id) { //조건값으로 선택한 특정 id 만 검색할거니깐. 알았냐
		
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		Dog dog = null;

		try{
			String sql="select * from dog where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id); //해당아이디를 가지고있는 도그의 정보를 추적해와라!
			rs =pstmt.executeQuery();
			
			if(rs.next()){ //데이터가 여러개가 아니기 때문에 한번만 돌면된다. 그래서 while이 아닌 if
				dog = new Dog();
				dog.setId(rs.getInt("id"));
				dog.setKind(rs.getString("kind"));
				dog.setContent(rs.getString("content"));
				dog.setPrice(rs.getInt("price"));
				dog.setWeight(rs.getInt("weight"));
				dog.setHeight(rs.getInt("height"));
				dog.setImage(rs.getString("image"));
				dog.setCountry(rs.getString("country"));
				dog.setReadcount(rs.getInt("readcount"));
				
				// dogs.add(dog); 더할 필요가 없다. 한번만 돌거니깐. 그래서 if사용한거고. ㅇㅋ?
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(rs);
		}
		return dog;
	}
	public boolean updateReadcount(String id) {
		
		PreparedStatement pstmt = null; 
		boolean result = false;

		try{
			String sql="update dog set readcount = readcount+1 where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id); //해당아이디를 가지고있는 도그의 정보를 추적해와라!
			int count =pstmt.executeUpdate();
			
			if(count > 0){ //카운트변수할당하고 카운트값이 0보다 크면 적용할 값이 하나 이상이라는 뜻.
				result = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}
		return result;
	}
}


