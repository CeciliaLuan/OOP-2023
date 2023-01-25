package ie.tudublin;

public class Cat
{
    int numLives = 9;
    String name;


	public void setName(String name)
	{
		this.name = name;
	}


    public void kill(int numLives)
    {

        if (numLives > 0) 
        {
          numLives = numLives - 1;
          System.out.println("Ouch");
        }
        else if( numLives == 0 ) 
        {
            System.out.println("Dead");
        }
    }

    
	
}
