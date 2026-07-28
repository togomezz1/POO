class profesor:
    def imprimir():
        return print('Es un profesor')

class profesor_titular(profesor):
    def __init__(self,años):
        self.años = años
    def imprimir():
        return print('Es un profesor titular')
    def imprimir_años(self):
        return print(f'Los años que ha sido profesor titular son: {self.años}')

## Codigo principal. 

Profesor = profesor_titular(0)
Profesor.imprimir_años()