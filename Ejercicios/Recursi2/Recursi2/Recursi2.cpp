#include "stdafx.h"
#include "iostream"
#include "conio.h"

using namespace std;

void cargar(int v[], int n){
 int x;
  for(int i=0;i<n;i++){
   cout<<"v["<<i<<"]=";
   cin>>x;
   v[i]=x; 
  }
}

void mostrar(int v[], int n){
  for(int i=0;i<n;i++)
    cout<<v[i]<<"  ";   
  cout<<endl;
}

//Suma los elementos de un vector
int suma(int v[], int n){
  if(n==0) //si alguien pone n=0
	return 0;  
  else
   if(n==1)  //caso base para 1 elemento
	 return v[0];
   else
   {
     int s=suma(v,n-1);
	 return s + v[n-1];
   }
}

int contar_posi(int v[], int n){
   if(n==1)  
	 return v[0]>0;  //se puede hacer con un IF yq retorn V y F
   else
   {
     int x=contar_posi(v,n-1);
	 if(v[n-1]>0)
		return x + 1;
	 else
		return x;
   }
}

int mayor(int v[], int n){
  if(n==1)
	 return v[0];  
  else   
  {
     int x=mayor(v,n-1);

	 if(v[n-1] > x)
	   return v[n-1];
	 else
	   return x;
  }
}

bool existe(int v[], int n,int x)
{
  if(n==1) //caso base
  {
     if(v[0]==x)
		 return true;
	 else
		 return false;
  }    
  else
  {
      bool b=existe(v,n-1,x);
	  if(b)
	    return true;
	  else
	  {
	    if(v[n-1]==x)    //Lo mismo poner: return v[n-1]==x
			return true;
		else 
			return false;
	  }
  }
}

//-------------------SEGUNDO PRINCIPIO DE INDUCCION COMPLETA------------------
//Devuelve la cantidad de parejas iguales en las posiciones impar-par
//Compara de 2 en dos desde n-2 Ej1.- 2 4 4 5 5, devuelve 2  Ej2.- 2 2 3 3 8 8, devuelve 3
int parejas(int v[],int n)
{
	if(n==1)
      return 0;
	else
	if(n==2)
	{
	  if(v[0]==v[1])
		  return 1;
	  else
		  return 0;	
	}
	else
	{
	   int x=parejas(v,n-2);  //HI
	   if(v[n-2]==v[n-1])     //xq el vector empieza en 0
		   return x + 1;
	   else
		   return x;
	}
}


int main()
{
  cout<<"RECURSIVIDAD"<<endl;
  int v[50];
  int n,x,k; 
  cout<<"Leer n:";
  cin>>n;
  cargar(v,n);
  mostrar(v,n);
  int s=suma(v,n);
  cout<<"La suma es:"<<s;
  
  return 0;	
}

