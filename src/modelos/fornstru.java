package modelos;

public class fornstru {

	private String nome;
	private String cod_forn;
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
	
	public void setcod_f(String pc){
		
		this.cod_forn=pc;
		
	}
	
	public String getcod_f(){
		
		return this.cod_forn;
		
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
	
}
