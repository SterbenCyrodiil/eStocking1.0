package modelos;

public class stockstru {
	
	private int codigo;
	private String nome;
	private String texto;
	private int cod_categ;
	private int quantidade;
	private double prec;
	private String cod_fornecedor;
	private String moeda;
	private String unidade;
	
	
	public void setcods(int pcod){
		
		 this.codigo=pcod;
			
		}
	
	public int getcods (){
		
		return this.codigo;
		
	}

	public void setnome(String pnome){
		
		 this.nome=pnome;
			
		}
	
	public String getnome (){
		
		return this.nome;
		
	}
	
	public void settexto(String ptexto){
		
		 this.texto=ptexto;
			
		}
	
	public String gettexto (){
		
		return this.texto;
		
	}
	
	public void setcod_c(int pcod_c){
		
		 this.cod_categ=pcod_c;
			
		}
	
	public int getcod_c (){
		
		return this.cod_categ;
		
	}
	
	public void setquantidade(int pquantidade){
		
		 this.quantidade=pquantidade;
			
		}
	
	public int getquantidade (){
		
		return this.quantidade;
		
	}
	
	public void setprec(double d){
		
		 this.prec=d;
			
		}
	
	public double getprec (){
		
		return this.prec;
		
	}

	public void setcod_f(String pcodf){
		
		 this.cod_fornecedor=pcodf;
			
		}
	
	public String getcod_f(){
		
		return this.cod_fornecedor;
		
	}
	
	public void setmoeda (String pmoeda){
		
		this.moeda=pmoeda;
		
	}
	
	public String getmoeda (){
		
		return this.moeda;
		
	}
	
public void setunidade (String punidade){
		
		this.unidade=punidade;
		
	}
	
	public String getunidade (){
		
		return this.unidade;
		
	}
	
	
				
}