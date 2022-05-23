package table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class BdTable {

    public BdTable(){}

        public Method constructGet()
        {
            Method[] meth=this.getClass().getDeclaredMethods();
            Method rep=null;
            for(int i=0;i<meth.length;i++)
            {
                if(meth[i].getName().equals("constructeur")==true)
                {
                    rep=meth[i];
                }
            }
            return rep;
        }
        public Method mitadyMeth(Field arg)
        {
            Method[] meth=this.getClass().getDeclaredMethods();
            Method valiny=null;
            String ana=null;
            char[] n=arg.getName().toCharArray();
            n[0]=Character.toUpperCase(n[0]);
            ana=Character.toString(n[0]);
            for(int j=1;j<n.length;j++)
            {
                ana+=Character.toString(n[j]);
            }
            for(int i=0;i<meth.length;i++)
            {
                
                //System.out.println("get"+ana);
                if(meth[i].getName().equals("get"+ana)==true)
                {
                    valiny=meth[i];
                }
            }
            return valiny;   
        }

        public void insertInto(Connection c) throws Exception
        {
            /*Method[] meth=this.getClass().getDeclaredMethods();*/
            Field[] fl=this.getClass().getDeclaredFields();
            System.out.println(fl.length);
            Vector attr=new Vector();
            String col="(";
            String nameRef=null;
            for(int i=0;i<fl.length-1;i++)
            {
               
                Method meth=mitadyMeth(fl [i]);
                
                attr.addElement(meth.invoke(this));
                col+=fl[i].getName()+",";
                //System.out.print(col);
            }
            Method methlast=mitadyMeth(fl[fl.length-1]);
            attr.addElement(methlast.invoke(this));
            col+=fl[fl.length-1].getName()+")";
            //System.out.println(attr.size());
            for(int i=0;i<fl.length;i++)
            {
                if(fl[i].getName().equals("id")==true) 
                {
                    nameRef=fl[i].getName();
                }   
            }
            String req="insert into "+getClass().getSimpleName();
            
            String val="(";
            for(int i=0;i<attr.size()-1;i++)
            {
                //System.out.println(fl[i].getType().getName());
                if(fl[i].getName().equals("id")==true)
                {
                    java.sql.Statement stmt = c.createStatement();
                    //ResultSet ret =stmt.executeQuery("select seq"+getClass().getSimpleName()+".nextval from dual");
                    System.out.println("SELECT nextval('seq"+getClass().getSimpleName()+"'");
                    ResultSet ret =stmt.executeQuery("SELECT nextval('seq"+getClass().getSimpleName()+"')");

                    while(ret.next()){
                        String retAzo =ret.getString(1);
                        val+=retAzo+",";
                    }
                }   
                if(fl[i].getType().getName().equals("java.lang.String")==true && fl[i].getName().equals("id")==false)
                {
                    val+="'"+attr.get(i).getClass().cast(attr.get(i))+"',";
                }
                if((fl[i].getType().getName().equals("int")==true || fl[i].getType().getName().equals("double")==true)  && fl[i].getName().equals("id")==false)
                {
                    val+=attr.get(i).getClass().cast(attr.get(i))+",";
                }
                if(fl[i].getType().getName().equals("java.sql.Date")==true)
                {
                    //val+="to_date('"+((java.sql.Date)(attr.get(i))).getDate()+"-"+(((java.sql.Date)(attr.get(i))).getMonth()+1)+"-"+((java.sql.Date)(attr.get(i))).getYear()+"','dd-mm-yyyy'),";
                    val+="'"+((java.sql.Date)(attr.get(i))).getYear()+"-"+(((java.sql.Date)(attr.get(i))).getMonth()+1)+"-"+((java.sql.Date)(attr.get(i))).getDate()+"',";
                }
                if(fl[i].getType().getName().equals("java.sql.Timestamp")==true)
                {
                    //val+="to_date('"+((java.sq"'"+((java.sql.Date)(attr.get(attr.size()-1))).getYear()+"-"+(((java.sql.Date)(attr.get(attr.size()-1))).getMonth()+1)+"-"+((java.sql.Date)(attr.get(attr.size()-1))).getDate()+"',l.Date)(attr.get(attr.size()-1))).getDate()+"-"+(((java.sql.Date)(attr.get(attr.size()-1))).getMonth()+1)+"-"+((java.sql.Date)(attr.get(attr.size()-1))).getYear()+",'dd-mm-yyyy')";
                    val+="(select CURRENT_TIMESTAMP),";
                }
                                
            }
            //col+=fl[attr.size()-1]+")";
            
            if(fl[attr.size()-1].getName().equals("id")==true)
            {
                java.sql.Statement stmt = c.createStatement();
                //ResultSet ret =stmt.executeQuery("select seq"+getClass().getSimpleName()+".nextval from dual");
                ResultSet ret =stmt.executeQuery("SELECT nextval('seq"+getClass().getSimpleName()+"'");
                String retAzo =ret.getString(1);
                val+=retAzo+")";
            } 
            if(fl[attr.size()-1].getType().getName().equals("java.lang.String")==true && fl[attr.size()-1].getName().equals("id")==false )
            {
                val+="'"+attr.get(attr.size()-1).getClass().cast(attr.get(attr.size()-1))+"')";
            }
            if((fl[attr.size()-1].getType().getName().equals("int")==true || fl[attr.size()-1].getType().getName().equals("double")==true)  && fl[attr.size()-1].getName().equals("id")==false)
            {
                val+=attr.get(attr.size()-1).getClass().cast(attr.get(attr.size()-1))+")";
            }
            if(fl[attr.size()-1].getType().getName().equals("java.sql.Date")==true)
                {
                    //val+="to_date('"+((java.sql.Date)(attr.get(attr.size()-1))).getDate()+"-"+(((java.sql.Date)(attr.get(attr.size()-1))).getMonth()+1)+"-"+((java.sql.Date)(attr.get(attr.size()-1))).getYear()+",'dd-mm-yyyy')";
                    val+="'"+((java.sql.Date)(attr.get(attr.size()-1))).getYear()+"-"+(((java.sql.Date)(attr.get(attr.size()-1))).getMonth()+1)+"-"+((java.sql.Date)(attr.get(attr.size()-1))).getDate()+"',";
                }
            if(fl[attr.size()-1].getType().getName().equals("java.sql.Timestamp")==true)
                {
                    //val+="to_date('"+((java.sq"'"+((java.sql.Date)(attr.get(attr.size()-1))).getYear()+"-"+(((java.sql.Date)(attr.get(attr.size()-1))).getMonth()+1)+"-"+((java.sql.Date)(attr.get(attr.size()-1))).getDate()+"',l.Date)(attr.get(attr.size()-1))).getDate()+"-"+(((java.sql.Date)(attr.get(attr.size()-1))).getMonth()+1)+"-"+((java.sql.Date)(attr.get(attr.size()-1))).getYear()+",'dd-mm-yyyy')";
                    val+="(select CURRENT_TIMESTAMP))";
                }
            
            

            req+=col+" values "+val;
             System.out.print(req);
            java.sql.Statement stmt = c.createStatement();
            int ret =stmt.executeUpdate(req);
            //return req;
        }

        public void updateTo(Connection c) throws Exception
        {
            Field[] fl=this.getClass().getDeclaredFields();
            /*Method[] meth=this.getClass().getDeclaredMethods();*/
            Vector attr=new Vector();
            Object valRef=null;
            String nameRef="id";
            for(int i=0;i<fl.length;i++)
            {
                Method meth=mitadyMeth(fl[i]);
                attr.addElement(meth.invoke(this));
            }
            for(int i=0;i<fl.length;i++)
            {
                if(fl[i].getName().equals(nameRef)==true) 
                {
                    Method meth=mitadyMeth(fl[i]);
                    valRef=meth.invoke(this);
                }   
            }
            String req="update "+getClass().getSimpleName()+" set ";
                for(int i=0;i<attr.size()-1;i++)
                {
                    if(fl[i].getType().getName().equals("int")==true || fl[i].getType().getName().equals("double")==true)
                    {
                        req+=fl[i].getName()+"="+attr.get(i).getClass().cast(attr.get(i))+",";
                    } 
                    if(fl[i].getType().getName().equals("java.sql.Timestamp")==true){
                        req+=fl[i].getName()+"=(SELECT convert(datetime, '"+attr.get(i).getClass().cast(attr.get(i))+"', 121)),";
                    }
                    else  req+=fl[i].getName()+"='"+attr.get(i).getClass().cast(attr.get(i))+"',";
                }
                
                if(fl[attr.size()-1].getType().getName().equals("int")==true || fl[attr.size()-1].getType().getName().equals("double")==true)
                {
                    req+=fl[attr.size()-1].getName()+"="+attr.get(attr.size()-1).getClass().cast(attr.get(attr.size()-1));
                } 
                if(fl[attr.size()-1].getType().getName().equals("java.sql.Timestamp")==true){
                        req+=fl[attr.size()-1].getName()+"=(SELECT convert(datetime, '"+attr.get(attr.size()-1).getClass().cast(attr.get(attr.size()-1))+"', 121))";
                }else {
                    req+=fl[attr.size()-1].getName()+"='"+attr.get(attr.size()-1).getClass().cast(attr.get(attr.size()-1))+"'";
                } 
                req+=" where "+nameRef+"='"+valRef.getClass().cast(valRef)+"'";
            System.out.println(req);
            java.sql.Statement stmt = c.createStatement();
            int ret =stmt.executeUpdate(req);
        }

        public void deleteInto(Connection c) throws Exception
        {
            Field[] fl=this.getClass().getDeclaredFields();
            /*Method[] meth=this.getClass().getDeclaredMethods();*/
            Vector attr=new Vector();
            for(int i=0;i<fl.length;i++)
            {
                Method meth=mitadyMeth(fl[i]);
                attr.addElement(meth.invoke(this));
            }
            String req="delete from "+getClass().getSimpleName()+" where "+fl[0].getName()+"='"+attr.get(0).getClass().cast(attr.get(0))+"'";
            java.sql.Statement stmt = c.createStatement();
            int ret =stmt.executeUpdate(req);
            System.out.println(req);
        }

        public Field[] fieldNotNull(BdTable tab)throws Exception
        {
            Field[] fl=tab.getClass().getDeclaredFields();
            Vector vect=new Vector();
            for(int i=0;i<fl.length;i++)
            {
                if(fl[i].getType().getName().equals("String")==true)
                {
                    if(tab.mitadyMeth(fl[i]).invoke(tab)!=null)
                        {
                            vect.addElement(fl[i]);
                        }
                }
                if(fl[i].getType().getName().equals("int")==true && (int)(tab.mitadyMeth(fl[i]).invoke(tab))!=0 || fl[i].getType().getName().equals("double")==true 
                && (double)(tab.mitadyMeth(fl[i]).invoke(tab))!=0)
                {
                    vect.addElement(fl[i]);
                }
            }
            Field[] val=new Field[vect.size()];
            for(int i=0;i<vect.size();i++)
            {
                val[i]=(Field)vect.get(i);
            }
            return val;
        }
    
    
        public Vector findReq(String req,BdTable filtre,Connection c)throws Exception
        {
            java.sql.Statement stmt = c.createStatement();
            ResultSet set =stmt.executeQuery(req);
            Method[] meth=filtre.getClass().getDeclaredMethods();
            Vector val=new Vector();
            while(set.next())
            {
                Object[] argument=new Object[1];
                argument[0]=set;
                System.out.println();
                val.addElement(filtre.constructGet().invoke(filtre,argument));
            }
            
            return val;
        }
    
        public Vector find(BdTable filtre,Connection c)throws Exception
        {
            Field[] fl=fieldNotNull(filtre);
            String req="select * from "+filtre.getClass().getSimpleName();
            //System.out.println(req);
            if(fl.length==0)
            {
                req=req;
            }
            else{
                req+=" where ";
                for(int i=0;i<fl.length;i++)
                {
                    if(fl[i].getType().getName().equals("String")==true)
                    {
                        req+=fl[i].getName()+"='"+filtre.mitadyMeth(fl[i]).invoke(filtre).getClass().cast(filtre.mitadyMeth(fl[i]).invoke(filtre))+"' and ";
                    }
                    if(fl[i].getType().getName().equals("int")==true ||  fl[i].getType().getName().equals("double")==true)
                    {
                        req+=fl[i].getName()+"="+filtre.mitadyMeth(fl[i]).invoke(filtre).getClass().cast(filtre.mitadyMeth(fl[i]).invoke(filtre))+" and ";
                    }
                      
                }
                if(fl[fl.length-1].getType().getName().equals("String")==true)
                {
                    req+=fl[fl.length-1].getName()+"='"+filtre.mitadyMeth(fl[fl.length-1]).invoke(filtre).getClass().cast(filtre.mitadyMeth(fl[fl.length-1]).invoke(filtre))+"'";
                }
                if(fl[fl.length-1].getType().getName().equals("int")==true || fl[fl.length-1].getType().getName().equals("double")==true)
                {
                    req+=fl[fl.length-1].getName()+"="+filtre.mitadyMeth(fl[fl.length-1]).invoke(filtre).getClass().cast(filtre.mitadyMeth(fl[fl.length-1]).invoke(filtre))+"";
                }
               
            }
            Vector rep=findReq(req,filtre,c);
            return rep;
        }

    
}