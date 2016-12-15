import java.net.URL;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.nio.charset.*;

public class URLCrawler {
	private static ConcurrentLinkedQueue<String> urls;
	private int cnt;
	private static String charset;
	
	public URLCrawler() {
		// swing could be added
		urls = new ConcurrentLinkedQueue<>();
		urls.add( "http://www.dstang.com" );
		cnt = 0;
		while(!urls.isEmpty()){
			String url = urls.poll();
			System.out.println(url);
			new Thread( ()-> {
				try{					
					String content = download(
						new URL(url), getCharset(new URL(url)));
					// non-repeat crawler could be modified
					List<String> moreUrl = parse( content );
					urls.addAll(moreUrl);
					//System.out.println(moreUrl);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}).start();
				
			if(cnt++>5) break;
			try{ Thread.sleep(4000); }catch(InterruptedException ex){ System.out.println("Interrupted"); }
		}
		System.out.println("Crawler Terminated");
	}
	
	public static void main(String[] args) {
		URLCrawler crawler = new URLCrawler();
	}

	static List<String> parse(String text) {
		String patternString = 
			"\\s*href\\s*=\\s*(\"([^\"]*\")|(\'[^\']*\')|([^\'\">\\s]+))\\s*"; 
 		Pattern pattern = Pattern.compile(patternString, 
			Pattern.CASE_INSENSITIVE  );  //  Pattern.MULTILINE
		Matcher matcher = pattern.matcher( text );
		List<String> list = new ArrayList<>();
		while (matcher.find()) {
			String href = matcher.group(1);
			href = href.replaceAll("\'","").replaceAll("\"","");
			if(href.startsWith("http:"))
				list.add(href); 
		}
		return list;
	}

	static String download( URL url, String charset)
		throws Exception
	{
		try(InputStream input 
				= url.openStream();
			ByteArrayOutputStream output 
				= new ByteArrayOutputStream())
		{
			byte[] data = new byte[1024];
			int length;
			while((length=input.read(data))!=-1){
				output.write(data,0,length);
			}
			byte[] content = output.toByteArray();
			return new String(content, Charset.forName(charset));
		}
	}
	
	static String getCharset(URL url) {
		/**
		String charset = null;
		try {
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.connect();
			System.out.println(urlConnection.getOutputStream());
			Map<String, List<String>> map = urlConnection.getHeaderFields();
			Set<String> keys = map.keySet();
			Iterator<String> iterator = keys.iterator();
			
			String key = null;
			String tmp = null;
			
			while(iterator.hasNext()) {
				key = iterator.next();
				tmp = map.get(key).toString().toLowerCase();
				System.out.println(tmp);
				if (key != null && key.equals("Content-Type"));
					int m = tmp.indexOf("charset=");
					if (m != -1) {
						charset = tmp.substring(m + 8).replace("]", "");
					}		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(charset);
		return charset;
		
		this methods not necessarily get the charset since Content-Type not always has charset=
		*/
		charset = null;
		StringBuffer sb = new StringBuffer();
		String line;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		String htmlcode = sb.toString();
		String strbegin = "<meta";
		String strend = ">";
		String strtmp;
		int begin = htmlcode.indexOf(strbegin);
		int end = -1;
		int inttmp;
		Outer: while (begin > -1) {
			end = htmlcode.substring(begin).indexOf(strend);
			if (begin > -1 && end > -1) {
				strtmp = htmlcode.substring(begin, begin + end);
				inttmp = strtmp.indexOf("charset");
				if (inttmp > -1) {
					charset = strtmp.substring(inttmp + 7, end).replace(
							"=", "").replace("/", "").replace("\"", "").
							replace("\'", "").replace(" ", "");
					break Outer;
				}
			}
		}
		/**
		 * The actual position where charset belongs to.
		 */
		return charset;
	}

		
}


