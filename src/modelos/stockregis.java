package modelos;

public class stockregis {
	
	private int cod_reg;
	private String 	cod_produto;
	private String data;
	private int quantidade;
	private double prec;
	private String tipo;
	

	public void setcodr(int pcod){
		
		 this.cod_reg=pcod;
			
		}
	
	public int getcodr (){
		
		return this.cod_reg;
		
	}

	public void setcodp(String pcod){
		
		 this.cod_produto=pcod;
			
		}
	
	public String getcodp(){
		
		return this.cod_produto;
		
	}
	
	public void setdata(String pdata){
		
		 this.data=pdata;
			
		}
	
	public String getdata(){
		
		return this.data;
		
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

	public void settipo(String ptipo){
		
		 this.tipo=ptipo;
			
		}
	
	public String gettipo(){
		
		return this.tipo;
		
	}

}
