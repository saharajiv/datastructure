package datastructure.helper;

//- LJVExample.java --- Some example visualizations

//- Author:     John Hamer <J.Hamer@cs.auckland.ac.nz>
//- Created:    Mon Jul 12 15:24:19 2004
//- Time-stamp: <2004-08-23 12:47:15 jham005>

//- Copyright (C) 2004  John Hamer, University of Auckland
//-
//-   This program is free software; you can redistribute it and/or
//-   modify it under the terms of the GNU General Public License
//-   as published by the Free Software Foundation; either version 2
//-   of the License, or (at your option) any later version.
//-   
//-   This program is distributed in the hope that it will be useful,
//-   but WITHOUT ANY WARRANTY; without even the implied warranty of
//-   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//-   GNU General Public License for more details.
//-   
//-   You should have received a copy of the GNU General Public License along
//-   with this program; if not, write to the Free Software Foundation, Inc.,
//-   59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.

//- $Id: LJVExample.java,v 1.2 2004/07/14 02:14:14 jham005 Exp $

import java.util.ArrayList;

class LJVExample {

public static void main( String[] args ) {
  LJV.Context def = LJV.getDefaultContext( );
  def.outputFormat = "ps";
  def.treatAsPrimitive( String.class );

  LJV.Context showAllCtx = LJV.newContext( );
  showAllCtx.outputFormat = "ps";
  showAllCtx.ignorePrivateFields = false;

  {
    //- String is not a primitive type
    LJV.drawGraph( showAllCtx, "Hello" );
  }
  
  //- Object arrays hold references; primitive arrays hold values
  LJV.drawGraph( new Object[]{ new String[]{ "a", "b", "c" },
                               new int[]{ 1, 2, 3 } } );

  {
    //- Assignment does not create a new object
    String x = "Hello";
    String y = x;
    LJV.drawGraph( showAllCtx, new Object[]{ x, y } );
  }

  {
    String x = "Hello";
    String y = new String(x);
    LJV.drawGraph( showAllCtx, new Object[]{ x, y } );
  }

  //- How multi-dimensional arrays are represented in Java.
  LJV.drawGraph( new int[4][5] );
  
  {
    //- Cyclical structures, classes (with and) without a toString.
    Node n  = new Node( "top",   2 );
    n.left  = new Node( "left",  1 );
    n.right = new Node( "right", 1 );
    n.right.left  = n;
    n.right.right = n;
    
    LJV.Context ctx = LJV.newContext( );
    ctx.outputFormat = "ps";
    ctx.setFieldAttribute( "left",  "color=red,fontcolor=red"  );
    ctx.setFieldAttribute( "right", "color=blue,fontcolor=blue" );
    ctx.setClassAttribute( Node.class, "color=pink,style=filled" );
    ctx.ignoreField( "level" );
    ctx.ignoreField( "ok" );
    ctx.treatAsPrimitive( String.class );
    ctx.showFieldNamesInLabels = false;
    
    LJV.drawGraph( ctx, n );
  }

  {
    //- Paul's example
    LJV.Context ctx = LJV.newContext( );
    ctx.outputFormat = "ps";
    if( false )
      ctx.treatAsPrimitive( String.class );
    else {
      ctx.ignoreField( "hash" );
      ctx.ignoreField( "count" );
      ctx.ignoreField( "offset" );
    }
    ArrayList a = new ArrayList();
    a.add(new Person("Albert", true, 35));
    a.add(new Person("Betty", false, 20));
    a.add(new java.awt.Point(100, -100));
    LJV.drawGraph( ctx, a );
  }
}


static class Node {
  String name;
  int level;
  boolean ok;
  Node left, right;
  public Node( String n, int l ) {
    name = n;
    level = l;
    ok = l%2 == 0;
  }
  public String toString( ) { return ""; }
}



static class Person {
  private String name;
  private boolean isMale;
  private int age;
  public Person(String n, boolean m, int a) {
    name = n;
    isMale = m;
    age = a;
  }
}
}