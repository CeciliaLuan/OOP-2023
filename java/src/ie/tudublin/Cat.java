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
        int i;

        for(i=0; i<9; i++)
        {

        if (numLives > 0) 
        {
          
          System.out.println("Ouch");
          --numLives;
        }
        else if( numLives == 0 ) 
        {
            System.out.println("Dead");
        }
        }
    }

    
	
}
