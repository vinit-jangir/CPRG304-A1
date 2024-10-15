package src.appDomain;

import src.shapes.*;

public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

		// refer to demo03 OfficeManager.java on how to create specific
		// objects using reflection from a String
            
            //Example Shapes
            Cone cone = new Cone(4,3);  
            SquarePrism prism = new SquarePrism(2,3);
            
            //Example Volume Cacluations:
            System.out.println("Cone Volume: " + cone.calcVolume());
            System.out.println("SquarePrism Volume: " + prism.calcVolume());
            
            Cylinder cylinder = new Cylinder(2,4);
            
            //Shapes and Prism are working with height comparison.
            System.out.println(cone.compareTo(cylinder));
            
            //Shape volume works.
            System.out.println(cone.baseAreaComparator(cylinder));
	}

}
