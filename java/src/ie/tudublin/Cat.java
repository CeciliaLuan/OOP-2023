package ie.tudublin;

public class Cat
{
    int numLives;
    String name;


	public void setName(String name)
	{
		this.name = name;
	}

    public Cat()
    {
      numLives = 9;
    }

    public void setLives(int numLives){
        this.numLives = numLives;
    }


    public void kill(int numLives)
    {
         int i;
        

        for(i= 0; i < 10; i++){

        
         numLives -= 1;
       

        if (numLives > 0) 
        {
          
          System.out.println("Ouch");
          
        }
        else if( numLives == 0 )   
        {
            System.out.println("Dead");
        }
      }   
    }

    
	
}
