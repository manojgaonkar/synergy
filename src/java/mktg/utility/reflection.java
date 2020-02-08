/*
 * reflection.java
 *
 * Created on January 7, 2009, 10:37 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import javax.naming.NamingException;
import javax.servlet.http.Cookie;

/*
 * reflaction.java
 *
 * Created on June 6, 2008, 11:47 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

class reflection {

   public static void main(String[] args) throws NamingException {
       
       Cookie O = new Cookie("ck","My Cookie");
      
      System.out.println("\n========  CLASS MODIFIERS ========\n");
      printModifiers(O);
      
      System.out.println("\n========  CONSTRUCTORS ========\n");
      showConstructors(O);
      
      System.out.println("\n========  METHODs ========\n");
      showMethods(O);
      
      System.out.println("\n========  SUPER CLASS ========\n");      
      printSuperclasses(O);
      
      System.out.println("\n======== INTERFACES ========\n");      
      verifyInterface(O.getClass());      
      
      System.out.println("\n======== INTERFACES IMPLETED BY CLASS========\n");      
      printInterfaceNames(O);      
      
   }

   static void showConstructors(Object o) {
      Class c = o.getClass();
      Constructor[] theConstructors = c.getConstructors();
      for (int i = 0; i < theConstructors.length; i++) {
         System.out.print("( ");
         Class[] parameterTypes = 
            theConstructors[i].getParameterTypes();
         for (int k = 0; k < parameterTypes.length; k ++) {
            String parameterString = parameterTypes[k].getName();
            System.out.print(parameterString + ",");
            }
         System.out.println(")");
         }
   }
   
   static void showMethods(Object o) {
      Class c = o.getClass();
      Method[] theMethods = c.getMethods();
      for (int i = 0; i < theMethods.length; i++) {
         String methodString = theMethods[i].getName();
         System.out.println("\nName: " + methodString);
         String returnString =
           theMethods[i].getReturnType().getName();
         System.out.println("   Return Type: " + returnString);
         Class[] parameterTypes = theMethods[i].getParameterTypes();
         System.out.print("   Parameter Types:");
         for (int k = 0; k < parameterTypes.length; k ++) {
            String parameterString = parameterTypes[k].getName();
            System.out.print(" " + parameterString);
         }
         System.out.println();
      }
   
   }
   
   
   static void printSuperclasses(Object o) {
      Class subclass = o.getClass();
      Class superclass = subclass.getSuperclass();
      while (superclass != null) {
         String className = superclass.getName();
         System.out.println(className);
         subclass = superclass;
         superclass = subclass.getSuperclass();
      }
   }
   
   
   static void verifyInterface(Class c) {
      String name = c.getName();
      if (c.isInterface()) {
         System.out.println(name + " is an interface.");
      } else {
         System.out.println(name + " is a class.");
      }
   }
   
   
   static void printInterfaceNames(Object o) {
      Class c = o.getClass();
      Class[] theInterfaces = c.getInterfaces();
      for (int i = 0; i < theInterfaces.length; i++) {
         String interfaceName = theInterfaces[i].getName();
         System.out.println(interfaceName);
      }
   }   
   
   public static void printModifiers(Object o) {
      Class c = o.getClass();
      int m = c.getModifiers();
      if (Modifier.isPublic(m))
         System.out.println("public");
      if (Modifier.isAbstract(m))
         System.out.println("abstract");
      if (Modifier.isFinal(m))
         System.out.println("final");
   }
   
   
}



    
