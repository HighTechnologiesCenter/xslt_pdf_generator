import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.xml.sax.*;
import javax.xml.transform.sax.*; 
import javax.xml.transform.stream.*; 
import javax.xml.transform.*; 
import org.apache.fop.apps.*;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.MimeConstants;

import org.apache.tomcat.util.http.fileupload.*; 

public class pdfgen extends HttpServlet
{
	public void doGet(HttpServletRequest oRequest,HttpServletResponse oResponse)
	throws IOException, ServletException
	{
		try 
		{								
			oRequest.getRequestDispatcher("/WEB-INF/info.jsp").forward(oRequest, oResponse);
		}
		catch( Exception e ) 
		{
			e.printStackTrace();
			throw new ServletException( e.getMessage() );	
		}
	}

	public void doPost(HttpServletRequest oRequest,HttpServletResponse oResponse)
	throws IOException, ServletException
	{
		FopFactory fopFactory = FopFactory.newInstance();
		try 
		{								
			TransformerFactory factory = null;
			Transformer transformer = null;			
			Source xslt = null;
			Source src = null;

			List<FileItem> items = new FileUpload(new DefaultFileItemFactory()).parseRequest(oRequest);
		        for (FileItem item : items)
			{
				if (item.getFieldName().equals("xml"))
				{
					src = new StreamSource(item.getInputStream());
				}
				if (item.getFieldName().equals("xslt"))
				{
					xslt = new StreamSource(item.getInputStream());
					factory = TransformerFactory.newInstance();
					transformer = factory.newTransformer(xslt);
				}
		        }

			if ((xslt!=null) && (transformer!=null) && (src!=null))
			{
				oResponse.setContentType("application/pdf");
				Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, oResponse.getOutputStream());
				Result res = new SAXResult(fop.getDefaultHandler());
				transformer.transform(src, res);
			}
			else
			{
        			oRequest.getRequestDispatcher("/WEB-INF/info.jsp").forward(oRequest, oResponse);
			}
		}
		catch( Exception e ) 
		{
			e.printStackTrace();
			throw new ServletException( e.getMessage() );	
		}
	}

}