import math 
#### Problema 2.4 - Figuras geometricas

### Clase circulo 

class circulo():

    ## Constructor de la clase
    def __init__(self,radio):
        self.radio = radio 
    
    ## Método - Area

    def area(self):
        return math.pi*math.pow(self.radio,2)

    ## Método perimetro 

    def perimetro(self):
        return 2*math.pi*self.radio

class rectangulo():

    ### constructor de la clase

    def __init__(self, base, altura):
        self.base = base
        self.altura = altura
    
    ## Método - area

    def area(self):
        return self.base * self.altura
    
    ## Método perimetro 

    def perimetro(self):
        return 2*self.base + 2*self.altura

class cuadrado():

    ## Constructor de la clase

    def __init__(self, lado):
        self.lado = lado

    ## Método - area
    def area(self): 
        return math.pow(self.lado,2)

    ## Método - perimetro 
    def perimetro(self):
        return self.lado*4

class triangulo():

    ## Constructor de la clase
    def __init__(self,base,altura):
        self.base = base
        self.altura = altura
    
    ## Metodo - área

    def area(self):
        return (self.base*self.altura)/2
    
        
    ## Método - hipotenusa: Valido solo para triangulo rectangulos

    def hipotenusa(self):
        return math.pow(math.pow(self.base,2)+ math.pow(self.altura,2),0.5)
    
    
    ## Método - perimetro 

    def perimetro(self):
        return self.base + self.altura + triangulo.hipotenusa(self)
    
    ## Método - tipo de triangulo 

    def tipo(self):
        b,h = self.base, self.altura
        H = triangulo.hipotenusa(self) # Hipotenusa
        if ( (b == h) and (b == H) and (h == H)):
            print('El triangulo es equilatero!') # Todos sus lados son iguales
        elif ( (b != h) and (b != H) and (h != H)  ):
            print('El triangulo es escaleno!') # Todos sus lados son distintos
        else: 
            print('El triangulo es isósceles')

class rombo():

    def __init__(self, diagonal_mayor, diagonal_menor):
        self.dm = diagonal_mayor
        self.dme = diagonal_menor
    
    def area(self):
        return (self.dm * self.dme) /2
    
    def perimetro(self):
        lado = math.pow( math.pow(self.dm/2,2)+math.pow(self.dme/2,2) ,0.5)
        return 4 * lado

class trapecio():

    def __init__(self, base_mayor, base_menor, altura):
        self.bm = base_mayor
        self.bme = base_menor
        self.h = altura
    
    def area(self):
        return (self.bm + self.bme) * (self.h/ 2)
    
    def perimetro(self):
        x = (self.bm - self.bme) / 2
        c = math.pow( math.pow(self.h,2) + math.pow(x,2),0.5)
        d = math.pow(  math.pow(self.h,2) + math.pow( self.bm - self.bme  ,2), 0.5)
        return self.bm + self.bme + c + d ## Resultado solo valido para trapecio rectangulo
### codigo principal. Recibir parametros 

## Circulo 

radio = float(input('Ingrese el valor del radio del circulo en cm: '))
circulo_ = circulo(radio)
# prueba de los métodos
area_circulo = circulo_.area()
perimetro_circulo = circulo_.perimetro()
# Resultado de aplicar los métodos

print(f'El área del circulo es: {area_circulo}.\nEl perimetro del circulo es: {perimetro_circulo}')

## Rectangulo 

base = float(input('Ingrese el valor de la base del rectangulo en cm: '))
altura =  float(input('Ingrese el valor de la altura del rectangulo en cm: '))
rectangulo_ = rectangulo(base,altura)
#Prueba de los métodos
area_rectangulo = rectangulo_.area()
perimetro_rectangulo = rectangulo_.perimetro()

print(f'El área del rectangulo es: {area_rectangulo}.\nEl perimetro del rectangulo es: {perimetro_rectangulo}')


## Cuadrado 

lado = float(input('Ingrese el valor del lado del cuadrado en cm: '))
cuadrado_ = cuadrado(lado)
area_cuadrado = cuadrado_.area()
perimetro_cuadrado = cuadrado_.perimetro()

print(f'El área del cuadrado es: {area_cuadrado}.\nEl perimetro del cuadrado es: {perimetro_cuadrado}')

## Triangulo

baset = float(input('Ingrese el valor de la base del triangulo en cm: '))
alturat = float(input('Ingrese el valor de la altura del triangulo en cm: '))
triangulo_ = triangulo(baset,alturat)
area_triangulo = triangulo_.area()
perimetro_triangulo = triangulo_.perimetro()
hipotenusat = triangulo_.hipotenusa()

print(f'El área del triangulo es: {area_triangulo}.\nEl perimetro del triangulo es: {perimetro_triangulo}')
## Tipo de triangulo 
print(f'La hipotenusa del triangulo es: {hipotenusat}')
triangulo_.tipo()

## Rombo 

diagonal_mayor = float(input('Ingrese el valor de la diagonal mayor del rombo en cm: '))
diagonal_menor = float(input('Ingrese el valor de la diagonal menor del rombo en cm: '))
if diagonal_mayor < diagonal_menor: 
    raise ValueError('El valor de la diagonal mayor debe ser mayor que el de la diagonal menor')
rombo_ = rombo(diagonal_mayor, diagonal_menor)
area_rombo = rombo_.area()
perimetro_rombo = rombo_.perimetro()
print(f'El area del rombo es: {area_rombo}.\n El perimetro del rombo es: {perimetro_rombo}')

## Trapecio 
base_mayor = float(input('Ingrese el valor de la base mayor del trapecio en cm: '))
base_menor = float(input('Ingrese el valor de la base menor del trapecio en cm: '))
if base_mayor < base_menor: 
    raise ValueError('El valor de la base mayor debe ser mayor que el de la base menor')
altura_trapecio = float(input('Ingrese el valor de la altura del trapecio en cm: '))

trapecio_ = trapecio(base_mayor, base_menor, altura_trapecio)
area_trapecio = trapecio_.area()
perimetro_trapecio = trapecio_.perimetro()

print(f'El area del trapecio es: {area_trapecio}.\nEl perimetro del trapecio es: {perimetro_trapecio}')

