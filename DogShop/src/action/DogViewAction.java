package action;
import javax.servlet.http.*;
import biz.DogBiz;
import vo.ActionForward;
import vo.Dog;
public class DogViewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");//우선 ID값을 받아야한다.
		DogBiz dogBiz = new DogBiz();
		boolean result = dogBiz.updateReadcount(id); //조회수 증가
		
		Dog dog = dogBiz.getDog(id); //검색조건을 부여해서 id값을 넘겨준다
		Cookie cookie = new Cookie("image"+id,
				dog.getImage()); //클라이언트에서 넘어온 쿠키객체 넘어올 때 
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
        request.setAttribute("dog",dog);
		
        ActionForward forward = new ActionForward();
        forward.setUrl("dogView.jsp");
		return forward;
	}
}
