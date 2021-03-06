package physicssim;

/**
 * vectors in 3D space and their operations
 */
public class Vector3D implements Cloneable {

   public double[] vector;

   /**
    * 
    */
   public Vector3D() {
      this.vector = new double[] {0,0,0};
   }

   /**
    * 
    * @param vector vector (x,y,z)
    */
   public Vector3D(double[] vector) {
      this.vector = vector;
   }

   /**
    * 
    * @param x x coordinate
    * @param y y coordinate
    * @param z z coordinate
    */
   public Vector3D(double x, double y, double z) {
      this.vector = new double[] {x, y, z};
   }

   /**
    * Calculates distance between two vectors in 3D space. Order of vectors irrelevant.
    * @param v1 first vector
    * @param v2 second vector
    * @return distance
    */
   public static double distance(Vector3D v1, Vector3D v2) {
      return Math.sqrt(Math.pow(v1.vector[0] - v2.vector[0], 2) + Math.pow(v1.vector[1] - v2.vector[1], 2) + Math.pow(v1.vector[2] - v2.vector[2], 2));
   }

   /**
    * Normalized direction vector from v1 to v2
    * @param v1 origin
    * @param v2 vector
    * @return normalized direction vector
    */
   public static Vector3D normDirV(Vector3D v1, Vector3D v2) {
      Vector3D result = new Vector3D(new double[] {v2.vector[0] - v1.vector[0], v2.vector[1] - v1.vector[1], v2.vector[2] - v1.vector[2]});
      result.normalize();
      return result;
   }

   /**
    * Substract vector 1 from vector 2
    * @param v1 vector 
    * @param v2 vector
    * @return substracted new vector
    */
   public static Vector3D substract(Vector3D v1, Vector3D v2) {
      return new Vector3D(new double[] {v1.vector[0] - v2.vector[0], v1.vector[1] - v2.vector[1], v1.vector[2] - v2.vector[2]});
   }

   public void scale(double scalar) {
      vector[0] *= scalar;
      vector[1] *= scalar;
      vector[2] *= scalar;
   }

   /**
    * Normalizes the given position vector (length of vector is approx. 1)
    */
   public void normalize() {
      double length = length();
      for (int i = 0; i < 3; i++)
         vector[i] /= length;
   }

   public static Vector3D add(Vector3D v1, Vector3D v2) {
      return new Vector3D(new double[]{v1.vector[0]+v2.vector[0],v1.vector[1]+v2.vector[1],v1.vector[2]+v2.vector[2]});
   }

   /**
    * Determines length of a vector
    * @return length
    */
   public double length() {
      return Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2) + Math.pow(vector[2], 2));
   }

   /**
    * Reset vector with new values and array object
    * @param v new values
    */
   public void setVector(double[] v) {
      double[] newVector = new double[3];
      for (int i = 0; i < 3; i++)
         newVector[i] = v[i];
      vector = newVector;
   }

   @Override
   public Vector3D clone() {
      return new Vector3D(new double[]{vector[0],vector[1],vector[2]});
   }
}