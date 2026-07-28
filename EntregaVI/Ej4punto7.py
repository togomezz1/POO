from abc import ABC, abstractmethod

class animal(ABC):
    @abstractmethod
    def getNombreCientifico(self):
        pass
    @abstractmethod
    def getSonido(self):
        pass
    @abstractmethod
    def getAlimentos(self):
        pass
    @abstractmethod
    def getHabitat(self):
        pass

class canido(animal):
    pass

class felino(animal):
    pass

class perro(canido):
    def getNombreCientifico(self):
        return "Canis lupus familiaris"
    def getSonido(self):
        return "Ladrido"
    def getAlimentos(self):
        return "Carnívoro"
    def getHabitat(self):
        return "Doméstico"

class lobos(canido):
    def getNombreCientifico(self):
        return "Canis lupus"
    def getSonido(self):
        return "Aullido"
    def getAlimentos(self):
        return "Carnívoro"
    def getHabitat(self):
        return "Bosque"

class leones(felino):
    def getNombreCientifico(self):
        return "Panthera leo"
    def getSonido(self):
        return "Rugido"
    def getAlimentos(self):
        return "Carnívoro"
    def getHabitat(self):
        return "Praderas"

class gato(felino):
    def getNombreCientifico(self):
        return "Felis silvestris catus"
    def getSonido(self):
        return "Maullido"
    def getAlimentos(self):
        return "Ratones"
    def getHabitat(self):
        return "Doméstico"

def main():
    animales = [None] * 4 # Forma más "Pythonica" de iniciar una lista de tamaño fijo
    animales[0] = gato()
    animales[1] = perro()
    animales[2] = lobos()
    animales[3] = leones()
    
    for animal_obj in animales:
        print(animal_obj.getNombreCientifico())
        print("Sonido: ", animal_obj.getSonido())
        print("Alimentos: ", animal_obj.getAlimentos())
        print("Hábitat: ", animal_obj.getHabitat())
        print(" ")

if __name__ == "__main__":
    main()