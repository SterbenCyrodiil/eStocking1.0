package modelos;

public class faturastru {

	private int codigo;
	private String nome;
	private String ref;
	private int cod_categ;
	private int valor;
	private String cod_entidade;
	private String moeda;
	private String data;
	
	public void setcod_fa(int pcod){
		
		 this.codigo=pcod;
			
		}
	
	public int getcod_fa (){
		
		return this.codigo;
		
	}

	public void setnome(String pnome){
		
		 this.nome=pnome;
			
		}
	
	public String getnome (){
		
		return this.nome;
		
	}
	
	
	public void setcod_c(int pcod_c){
		
		 this.cod_categ=pcod_c;
			
		}
	
	public int getcod_c (){
		
		return this.cod_categ;
		
	}
	
	public void setref(String pref){
		
		 this.ref=pref;
			
		}
	
	public String getref (){
		
		return this.ref;
		
	}
	
	public void setvalor(int pvalor){
		
		 this.valor=pvalor;
			
		}
	
	public int getvalor (){
		
		return this.valor;
		
	}

	public void setcod_e(String pcode){
		
		 this.cod_entidade=pcode;
			
		}
	
	public String getcod_e (){
		
		return this.cod_entidade;
		
	}
	
	public void setmoeda (String pmoeda){
		
		this.moeda=pmoeda;
		
	}
	
	public String getmoeda (){
		
		return this.moeda;
		
	}
	
	public void setdata(String pdata){
		
		 this.data=pdata;
			
		}
	
	public String getdata(){
		
		return this.data;
		
	}
	
}
