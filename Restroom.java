/**
 *Title: Men in Restroom
 *Semester: COP3337 –Fall 2021
 *@author   Mariela Torres Zuniga
 *
 *  I affirm that this program is entirely my own work
 *  and none of it is the work of any other person.
 *
 *This program will print out occupied
 *stalls by men, however following the rule of
 *occupying the middle of the longest
 *sequence of unoccupied places. The program will print
 *a diagram indicating this behavior by printing out
 *an X on a line representing a stall.
 */



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
      This method will add a person in the middle of the longest sequence of
      empty stalls.
   */
   public void addOccupant()
   {
       int currentRun = 0;
       int beginRun = 0;
       int longestRun = 0;
       int maxBeginRun = 0;

       for (int i = 0; i < s.length+1 ; i++)
       {
           if (i == s.length)
           {
               if (currentRun > longestRun)
               {
                   longestRun = currentRun;
                   maxBeginRun = beginRun;
               }
           } else if (currentRun == 0 && s[i] ==   false)
           {
               beginRun = i;
               currentRun++;
           } else
           {
               if (s[i] == false)
               {
                   currentRun++;

               } else
               {
                   if (currentRun > longestRun)
                   {
                       longestRun = currentRun;
                       maxBeginRun = beginRun;
                   }
                   currentRun = 0;
               }
           }
       }
       s[maxBeginRun + longestRun / 2] = true;
   }

   /*
      Gets a string describing the current stall occupation
      @return a string with _ for an empty stall and X for an occupied one
   */
   public String getStalls()
   {
       String x = "";
       for (boolean y : s)
           x += y ? "X" : "_";
       return x;



   }


}
