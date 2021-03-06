package com.wyd.exchange.servlet.exchange;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.wyd.exchange.bean.GroupInfo;
import com.wyd.exchange.bean.GroupExchange;
import com.wyd.exchange.server.factory.ServiceManager;
import com.wyd.exchange.utils.CryptionUtil;

/**
 * 增加组
 * @author zgq
 */
public class AddGrpupServlet extends HttpServlet {
    private static final long serialVersionUID = 1911747458628093909L;

    // /private static final String CONTENT_TYPE = "text/html";
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @SuppressWarnings("static-access")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ret = "fail";
        try {
            byte[] data = CryptionUtil.inputStream2byte(req.getInputStream());
            String dataString = new String(CryptionUtil.Decrypt(data, ServiceManager.getManager().getConfiguration().getString("deckey")), "utf-8");
            JSONObject jsonObject = JSONObject.fromObject(dataString);
            GroupInfo groupInfo = (GroupInfo)jsonObject.toBean(jsonObject, GroupInfo.class);
            GroupExchange groupExchange = new GroupExchange();
            groupExchange.setServices(groupInfo.getServices());
            groupExchange.setRemark(groupInfo.getRemark());
            ServiceManager.getManager().getExchangeService().save(groupExchange);
            ret = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(200);
        ServletOutputStream out = resp.getOutputStream();
        OutputStreamWriter os = new OutputStreamWriter(out, "utf-8");
        os.write(ret);
        os.flush();
        os.close();
    }
}
