package action;
import javax.servlet.http.*;
import biz.CartBiz;
import vo.ActionForward;
public class DogCartRemoveAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String[] kinds = request.getParameterValues("delete1");
		CartBiz cartBiz = new CartBiz();
		cartBiz.removeCartItem(request,kinds);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setUrl("dogCartList.dog");
		return forward;
	}
}
