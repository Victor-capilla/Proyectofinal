package defii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ConexionBBDD {

	private String bd;
	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "BLACA";
	private String pwd = "lorca";
	private Connection conexion;
	

	public ConexionBBDD()  {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);
			
			if(!conexion.isClosed()) {
				System.out.println("Conexión establecida");
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}
		
	}
	
	public DefaultTableModel ConsultaTablaEmpleados() {
		String [] columnas={"ID_PRODUCTO","NOMBRE","PRECIO"};
		String [] registro=new String[3];
		
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT ID_PRODUCTO,NOMBRE,PRECIO FROM PRODUCTOS";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_PRODUCTO");
				 registro[1]=rset.getString("NOMBRE");
		         registro[2]=rset.getString("PRECIO");
		        
		         ModeloTabla.addRow(registro);
		         
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}public DefaultTableModel cobrar(int num) {
		String [] columnas={"NOMBRE","PRECIO","CANTIDAD","SUBTOTAL"};
		String [] registro=new String[4];
		
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "select nombre , precio , cantidad , (precio*cantidad) from tiene t , productos p where t.id_producto = p.id_producto and id_pedido = "+num+"";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 
				 registro[1]=rset.getString("NOMBRE");
		         registro[2]=rset.getString("PRECIO");
		         registro[0]=rset.getString("CANTIDAD");
		         registro[3]=rset.getString("(precio*cantidad)");
		        
		         ModeloTabla.addRow(registro);
		         
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	public  String[] categorias() {
		
		String [] registro=new String[3];
		
		
		String query = "SELECT nombre from categoria";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int m = 0 ;
			while(rset.next()) {
				 registro[m]=rset.getString("nombre");
				 
				 
		       m = m+1; 
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return registro;
		
	}public  String[] pedidos() {
		ArrayList<String> mi = new ArrayList<>();
		
		
		
		String query = "Select ID_PEDIDO FROM PEDIDO WHERE ID_MESA IN (select id_mesa from mesas where ocupada = 'V')";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int m = 0 ;
			while(rset.next()) {
				mi.add(rset.getString("ID_PEDIDO"));
				 
				 
		       
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		String [] registro=new String[mi.size()];
		for (int i = 0; i < mi.size(); i++) {
			registro[i] = mi.get(i);
		}
		return registro;
		
	}public  String[] catpedidos(int pedido) {
		ArrayList<String> mi = new ArrayList<>();
		
		
		
		String query = "Select nombre FROM categoria WHERE id_categoria IN (select id_categoria from   productos p ,   tiene t where t.id_producto =p.id_producto and id_pedido = "+pedido+")";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int m = 0 ;
			while(rset.next()) {
				 mi.add(rset.getString("nombre"));
				 
				 
		       m = m+1; 
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		String [] registro=new String[mi.size()];
		for (int i = 0; i < mi.size(); i++) {
			registro[i] = mi.get(i);
		}
		return registro;
		
	}public  String[] catpropedidos(int pedido, String categoria) {
		ArrayList<String> mi = new ArrayList<>();
		
		
		
		String query = "select nombre from productos where id_producto in (select id_producto from tiene where id_pedido = "+pedido+" ) and id_categoria in (select id_categoria from categoria where nombre ='"+categoria+"')";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int m = 0 ;
			while(rset.next()) {
				 mi.add(rset.getString("nombre"));
				 
				 
		       m = m+1; 
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		String [] registro=new String[mi.size()];
		for (int i = 0; i < mi.size(); i++) {
			registro[i] = mi.get(i);
		}
		return registro;}
		

	public  String[] productos(String categoria) {
		ArrayList<String> mi = new ArrayList<>();
		
		
		
		String query = "select nombre from productos where id_categoria in (select id_categoria from categoria where nombre = '"+categoria+"')";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int m = 0 ;
			while(rset.next()) {
				mi.add(rset.getString("NOMBRE"));
				 
				 
		       
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		String [] registro=new String[mi.size()];
		for (int i = 0; i < mi.size(); i++) {
			registro[i] = mi.get(i);
		}
		return registro;
		
	}
	public int conta (int num, int num2) {
		int r = 0 ;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			
			System.out.println("INSERT INTO pedido VALUES("+num+",0,"+num2+")");
			pe = "INSERT INTO pedido VALUES("+num+",0,"+num2+")";
			stmt.executeUpdate(pe);
			stmt.executeUpdate("update mesas set ocupada='V' where id_mesa ="+num2+"");
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int añadirproductocarta (String nombre, String celiaco,String precio , String cantidad,String id ,String id_cat) {
		int r = 0 ;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("select id_categoria from categoria where nombre = '"+id_cat+"'");
			while (rset.next()) {
				r = Integer.parseInt(rset.getString(1));
			}System.out.println(r);
			rset.close();
			
			
			
			pe = "INSERT INTO productos VALUES("+id+","+r+","+precio+",'"+celiaco+"','"+nombre+"',"+cantidad+")";
			stmt.executeUpdate(pe);
		
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int modificarproductocarta (String nombre, String celiaco,String precio , String cantidad,String id_cat, String productos) {
		int r =0 ;
		int s = 1;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("select id_producto from productos where nombre = '"+productos+"'");
			
			while (rset.next()) {
				
				r = Integer.parseInt(rset.getString(1));
			
			
			
			}rset.close();
			s = pro(id_cat);
			
			System.out.println("xddd"+r+"ss : "+s);
			
			
			
			if (nombre.length()<1) {
				System.out.println("nada nombre");	
			}else  {
				pe = "update productos set nombre = '"+nombre+"' where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}if (celiaco.length()<1) {
				System.out.println("nada celiaco");	
			}else  {
				pe = "update productos set celiaco = '"+celiaco+"' where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}if (precio.length() == 0) {
				System.out.println("nada precio");	
			}else  {
				pe = "update productos set precio = "+precio+" where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}if (cantidad.length()<1) {
				System.out.println("nada cantidad");	
			}else  {
				pe = "update productos set cantidad = "+cantidad+" where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}if (s<0 || s>2) {
				System.out.println("nada categoria");	
			}else  {
				pe = "update productos set id_categoria = '"+s+"' where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}
			
			
			
			
		
			stmt.close();
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int COBRar (String num, int num2) {
		int r = 0 ;
		
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("select id_mesa from pedido where id_pedido = "+num2+"");
			while (rset.next()) {
				r = Integer.parseInt(rset.getString(1));
			}
			rset.close();
			
			
			
			pe = "update pedido set precio_final = "+num+" where id_pedido ="+num2+"";
			stmt.executeUpdate(pe);
			stmt.executeUpdate("update mesas set ocupada='F' where id_mesa ="+r+"");
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int reducir (String producto, int pedido) {
		int r = 0 ;
		int s = 0 ;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset_1 = stmt.executeQuery("select id_producto from productos where nombre = '"+producto+"'");
			while (rset_1.next()) {
				r = Integer.parseInt(rset_1.getString(1));
			}
			rset_1.close();
			ResultSet rset = stmt.executeQuery("select cantidad from tiene where id_producto = "+r+" and id_pedido = "+pedido+"");
			while (rset.next()) {
				s = Integer.parseInt(rset.getString(1));
			}
			rset.close();
			if (s==0) {
				pe = "delete from tiene  where id_pedido = "+pedido+" and id_producto = "+r+" " ;
				stmt.executeUpdate(pe);
			}else if (s>0) {
				pe= "update tiene set cantidad = cantidad -1 where id_producto = "+r+" and id_pedido ="+pedido+" " ;
				stmt.executeUpdate(pe);
			}else {
				System.out.println("nada");
			}
			
			
			
			
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int eliminar (String producto, int pedido) {
		int r = 0 ;
		int s = 0 ;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			System.out.println("select id_producto from productos where nombre = '"+producto+"'");
			ResultSet rset_1 = stmt.executeQuery("select id_producto from productos where nombre = '"+producto+"'");
			while (rset_1.next()) {
				r = Integer.parseInt(rset_1.getString(1));
			}
			rset_1.close();
			
			
				pe = "delete from tiene  where id_pedido = "+pedido+" and id_producto = "+r+" " ;
				stmt.executeUpdate(pe);
			
			
			
			
			
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int eliminarpro (String producto) {
		int r = 0 ;
		int s = 0 ;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			System.out.println("select id_producto from productos where nombre = '"+producto+"'");
			
			
			
				pe = "delete from productos  where nombre = '"+producto+"' ";
				stmt.executeUpdate(pe);
			
			
			
			
			
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}public int pro (String producto) {
			int r = 0 ;
			int s = 0 ;
			String pe = null;
			try {
				Statement stmt = conexion.createStatement();
				System.out.println("select id_categoria from categoria where nombre = '"+producto+"'");
				
				ResultSet rset = stmt.executeQuery("select id_categoria from categoria where nombre = '"+producto+"'");
				while (rset.next()) {
					
					r = Integer.parseInt(rset.getString(1));
					
				}
					
					
				
				
				
				
				
				
				stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return r;}
	public double precio (int pedido) {
		double r = 0 ;
		String pe = null;
		String query = "Select sum(precio*cantidad) from tiene t, productos p where t.id_producto = p.id_producto and id_pedido = "+pedido+" ";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				r = Double.parseDouble(rset.getString("sum(precio*cantidad)"));				 
				 
		        
			}
			
			rset.close();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;}
	public String con () {
		String registro="";
	
	
	String query = "SELECT count(*) from pedido";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		int m = 0 ;
		while(rset.next()) {
			registro=rset.getString("count(*)");
			 
			 
	        
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return registro;}
	public String countproductos () {
		String registro="";
	
	
	String query = "SELECT count(*) from productos";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		int m = 0 ;
		while(rset.next()) {
			registro=rset.getString("count(*)");
			 
			 
	        
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return registro;}
	public DefaultTableModel mesasdis() {
		String [] columnas={"mesas"};
		String [] registro=new String[1];
		
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT ID_MESA from MESAS where ocupada = 'F'";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_MESA");
				
		        
		         ModeloTabla.addRow(registro);
		         
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
	
	

}public DefaultTableModel pedidosdis() {
	String [] columnas={"mesa", "pedido"};
	String [] registro=new String[2];
	
	DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
	String query = "Select ID_MESA , ID_PEDIDO FROM PEDIDO WHERE ID_MESA IN (select id_mesa from mesas where ocupada = 'V')";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			 registro[0]=rset.getString("ID_MESA");
			 registro[1]=rset.getString("ID_PEDIDO");
	        
	         ModeloTabla.addRow(registro);
	         
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;
	



}public DefaultTableModel propedidosdis(int pedido) {
	String [] columnas={"producto", "cantidad","precio"};
	String [] registro=new String[3];
	
	DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
	String query = "Select nombre , cantidad , precio*cantidad from productos p, tiene t where p.id_producto = t.id_producto and id_pedido = "+pedido+"";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			 registro[0]=rset.getString("nombre");
			 registro[1]=rset.getString("cantidad");
			 registro[2]=rset.getString("precio*cantidad");
	         ModeloTabla.addRow(registro);
	         
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;
}
}
