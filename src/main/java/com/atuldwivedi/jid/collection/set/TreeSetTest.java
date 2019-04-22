package com.atuldwivedi.jid.collection.set;

import com.atuldwivedi.jid.model.Car;
import com.atuldwivedi.jid.model.Person;
import com.atuldwivedi.jid.model.Student;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Tree set")
public class TreeSetTest {


    @Test
    @DisplayName("should throw NullPointerException while inserting null element")
    public void should_throw_NullPointerException_while_inserting_null_element() {
        assertThatNullPointerException().isThrownBy(() -> {
            TreeSet<String> treeSet = new TreeSet<>();
            treeSet.add("Foo");
            treeSet.add(null);
            treeSet.add("Bam");
        });
    }

    @Test
    @DisplayName("should throw NullPointerException while inserting null object")
    public void should_throw_NullPointerException_while_inserting_null_object() {
        assertThatNullPointerException().isThrownBy(() -> {
            TreeSet<Student> treeSet = new TreeSet<>();
            treeSet.add(new Student(1001L, "Foo"));
            treeSet.add(null);
            treeSet.add(new Student(1002L, "Bam"));
        });
    }

    @Test
    @DisplayName("should throw ClassCastException while inserting object which cannot be compared")
    public void should_throw_ClassCastException_while_inserting_object_which_cannot_be_compared() {
        assertThatExceptionOfType(ClassCastException.class).isThrownBy(() -> {
            TreeSet<Car> treeSet = new TreeSet<>();
            treeSet.add(new Car(1234L, "Foo"));
            treeSet.add(new Car(5678L, "Bar"));
            treeSet.add(new Car(4321L, "Bam"));
        });
    }

    @Test
    @DisplayName("should not preserve insertion order")
    public void should_not_preserve_insertion_order() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Foo");
        treeSet.add("Bam");
        treeSet.add("Bar");

        assertThat(treeSet).doesNotContainSequence("Foo", "Bam", "Bar");
    }

    @Test
    @DisplayName("should store elements sorted in ascending order by natural sorting")
    public void should_store_elements_sorted_in_ascending_order_by_natural_sorting() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Foo");
        treeSet.add("Bam");
        treeSet.add("Bar");

        assertThat(treeSet).containsExactly("Bam", "Bar", "Foo");
    }

    @Test
    @DisplayName("should store objects sorted in order as specified by the comparable")
    public void should_store_objects_sorted_in_order_as_specified_by_the_comparable() {
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student(1003L, "Foo"));
        treeSet.add(new Student(1002L, "Bar"));
        treeSet.add(new Student(1001L, "Bam"));

        Set<Student> expected = ImmutableSet.of(new Student(1001L, "Bam"),
                new Student(1002L, "Bar"), new Student(1003L, "Foo"));

        assertThat(treeSet).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("should store objects sorted in order as specified by the comparator")
    public void should_store_objects_sorted_in_order_as_specified_by_the_comparator() {
        TreeSet<Person> treeSet = new TreeSet<>(comparing(Person::getName));
        treeSet.add(new Person("Foo", 10));
        treeSet.add(new Person("Bam", 40));
        treeSet.add(new Person("Bar", 30));

        Set<Person> expected = ImmutableSet.of(new Person("Bam", 40),
                new Person("Bar", 30),
                new Person("Foo", 10));

        assertThat(treeSet).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("should store objects sorted in order as specified by the comparator on multiple fields")
    public void should_store_objects_sorted_in_order_as_specified_by_the_comparator_on_multiple_fields() {
        TreeSet<Person> treeSet = new TreeSet<>(comparing(Person::getName).thenComparing(Person::getAge));
        treeSet.add(new Person("Foo", 10));
        treeSet.add(new Person("Bam", 40));
        treeSet.add(new Person("Bar", 300));

        Set<Person> expected = ImmutableSet.of(new Person("Bam", 40), new Person("Bar", 300),
                new Person("Foo", 10));

        assertThat(treeSet).containsExactlyElementsOf(expected);
    }
}

