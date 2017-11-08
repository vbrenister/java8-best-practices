package edu.java8bp.optional;

import java.util.Objects;
import java.util.Optional;

//  Do not declare any instance variable of type Optional.
//  Use null to indicate optional data within the private scope of a class.
//  Use Optional for getters that access the optional field.
//  Do not use Optional in setters or constructors.
//  Use Optional as a return type for any other business logic methods that have an optional result.
//  Serializable issue
public class OptionalFieldsInPojo {

    // Bad
    class AddressWithOptional {
        private final String addressLine;
        private final String city;
        private final Optional<String> postcode;


        public AddressWithOptional(String addressLine, String city, Optional<String> postcode) {
            this.addressLine = Objects.requireNonNull(addressLine);
            this.city = Objects.requireNonNull(city);
            this.postcode = postcode;
        }

        public String getAddressLine() {
            return addressLine;
        }

        public String getCity() {
            return city;
        }

        public Optional<String> getPostcode() {
            return postcode;
        }
    }

    // Good
    class Address {
        private final String addressLine;
        private final String city;
        private final String postcode;

        public Address(String addressLine, String city) {
            this(addressLine, city, null);
        }

        public Address(String addressLine, String city, String postcode) {
            this.addressLine = Objects.requireNonNull(addressLine);
            this.city = Objects.requireNonNull(city);
            this.postcode = postcode;
        }

        public String getAddressLine() {
            return addressLine;
        }

        public String getCity() {
            return city;
        }

        public Optional<String> getPostcode() {
            return Optional.ofNullable(postcode);
        }
    }
}
