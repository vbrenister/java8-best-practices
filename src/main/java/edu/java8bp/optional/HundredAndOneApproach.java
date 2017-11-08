package edu.java8bp.optional;

import java.util.Optional;

import static java.util.Optional.empty;

public class HundredAndOneApproach {

    // Very Ugly
    class SameOldImperativeStyle {
        public String getPersonCarInsuranceName(Person person) {
            String name = "Unknown";
            if (Optional.ofNullable(person).isPresent()) {
                if (person.getCar().isPresent()) {
                    if (person.getCar().get().getInsurance().isPresent()) {
                        name = person.getCar().get().getInsurance().get().getName();
                    }
                }
            }
            return name;
        }
    }

    // Ugly
    class UsingIfPresentInTheSameImperativeStype {
        public String getPersonCarInsuranceName(Person person) {
            final StringBuilder sb = new StringBuilder();
            Optional.ofNullable(person).ifPresent(
                    p -> p.getCar().ifPresent(
                            c -> c.getInsurance().ifPresent(
                                    i -> sb.append(i.getName())
                            )
                    )
            );

            return sb.toString();
        }
    }

    // Bad
    class UsingMapWithUncheckedGet {
        public String getPersonCarInsuranceName(Person person) {
            return Optional.ofNullable(person)
                    .map(Person::getCar)
                    .map(car -> car.get().getInsurance())
                    .map(insurance -> insurance.get().getName())
                    .orElse("Unknown");
        }
    }


    // Ugly
    class UsingMapWithOrElseEmptyObjectToFixUncheckedGet {
        public String getPersonCarInsuranceName(Person person) {
            return Optional.ofNullable(person)
                    .map(Person::getCar)
                    .map(car -> car.orElseGet(Car::new).getInsurance())
                    .map(insurance -> insurance.orElseGet(Insurance::new).getName())
                    .orElse("Unknown");
        }
    }

    // Good
    class UsingFlatMap {
        public String getPersonCarInsuranceName(Person person) {
            return Optional.ofNullable(person)
                    .flatMap(p -> p.getCar())
                    .flatMap(c -> c.getInsurance())
                    .map(i -> i.getName())
                    .orElse("Unknown");
        }
    }

    // Best
    class UsingFlatMapAndMethodReference {
        public String getPersonCarInsuranceName(Person person) {
            return Optional.ofNullable(person)
                    .flatMap(Person::getCar)
                    .flatMap(Car::getInsurance)
                    .map(Insurance::getName)
                    .orElse("Unknown");
        }
    }


    class Person {
        Optional<Car> getCar() {
            return empty(); //stub
        }
    }

    class Car {
        Optional<Insurance> getInsurance() {
            return empty(); //stub
        }
    }

    class Insurance {
        String getName() {
            return ""; //stub
        }
    }
}
