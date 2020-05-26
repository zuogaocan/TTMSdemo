package xupt.se.ttms.webview.studio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.model.Studio;
import xupt.se.ttms.service.StudioSrv;


public class StudioUpdate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public StudioUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Studio stu = null;
		String type = request.getParameter("type");
		int id = 0;
		try {
			if (type.equals("modify")) {
				id = Integer.valueOf(request.getParameter("studioid"));
			}
			String name = request.getParameter("studioname");
			int rowCount = Integer.valueOf(request.getParameter("rowcount"));
			int colCount = Integer.valueOf(request.getParameter("colcount"));
			String intro = request.getParameter("intro");
			stu = new Studio(id, name, rowCount, colCount, intro);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if (type.equals("add")) {
				if(new StudioSrv().add(stu)==1)
					out.write("数据添加成功");
				else
					out.write("数据添加失败，请重试");
			} else{
				if(new StudioSrv().modify(stu)==1)
					out.write("数据修改成功");
				else
					out.write("数据修改失败，请重试");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("操作错误，请重试");
		}
	}
}
