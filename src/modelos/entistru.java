package modelos;

public class entistru {

	private String nome;
	private String cod_ent;
	private String morada;
	private String telefone;
	private String email;
	private String descr;
	
	public void setnome(String pn){
		
		this.nome=pn;
		
	}
	
	public String getnome(){
		
		return this.nome;
		
	}
	
	
	public void setmorada(String pm){
		
		this.morada=pm;
		
	}
	
	public String getmorada(){
		
		return this.morada;
		
	}
	
	public void settelefone(String ptelefone){
		
		this.telefone=ptelefone;
		
	}
	
	public String gettelefone(){
		
		return this.telefone;
		
	}
	
	public void setemail(String pem){
		
		this.email=pem;
		
	}
	
	public String getemail(){
		
		return this.email;
		
	}
	
	public void setdescr(String pdes){
		
		this.descr=pdes;
		
	}
	
	public String getdescr(){
		
		return this.descr;
		
	}
	
	public void setcod_e(String pc){
		
		this.cod_ent=pc;
		
	}
	
	public String getcod_e(){
		
		return this.cod_ent;
		
	}
	
}
