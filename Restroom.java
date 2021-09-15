/**
   A class that shows how restroom stalls are occupied.
*/

public class Restroom
{
private boolean[] s;

   /**
      Constructs a restroom with a given number of stalls.
      @param ns the number of stalls
   */
   public Restroom(int ns)
   {
       // Array gets populated here from the start
   s = new boolean[ns];
   }

   /*
      Adds an occupant in the middle of the longest sequence of
      unoccupied places. 
   */
   public void addOccupant()
   {
       int lengthOfRun = 0;
       int runStart = 0;
       int maxRun = 0;
       int maxRunStart = 0;
       for (int i = 0; i < s.length + 1; i++)
       {
           if (i == s.length)
           {
               if (lengthOfRun > maxRun)
               {
                   maxRun = lengthOfRun;
                   maxRunStart = runStart;
               }
           } else if (lengthOfRun == 0 && s[i] == false)
           {
               runStart = i;
               lengthOfRun++;
           } else
           {
               if (s[i] == false)
               {
                   lengthOfRun++;

               } else
               {
                   if (lengthOfRun > maxRun)
                   {
                       maxRun = lengthOfRun;
                       maxRunStart = runStart;
                   }
                   lengthOfRun = 0;
               }
           }
       }
       s[maxRunStart + maxRun / 2] = true;
   }

   /*
      Gets a string describing the current stall occupation
      @return a string with _ for an empty stall and X for an occupied one
   */
   public String getStalls()
   {
       String q = "";
       for (boolean a : s)
           q += a ? "X" : "_";
       return q;



   }


}
