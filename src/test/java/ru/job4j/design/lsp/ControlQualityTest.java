package ru.job4j.design.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenAddToWarehouse() {
        List<Store> stores = List.of(new Warehouse());
        List<Food> foods = List.of(
                new Food("milk",
                        LocalDate.now().plusDays(10),
                        LocalDate.now().minusDays(1),
                        50,
                        20),
                new Food("apple",
                        LocalDate.now().plusDays(20),
                        LocalDate.now().minusDays(5),
                        78,
                        30)
        );
        ControlQuality cq = new ControlQuality(stores);
        for (var food : foods) {
            cq.reallocate(food);
        }
        List<Food> expected = List.of(
                new Food("milk",
                        LocalDate.now().plusDays(10),
                        LocalDate.now().minusDays(1),
                        50,
                        20),
                new Food("apple",
                        LocalDate.now().plusDays(20),
                        LocalDate.now().minusDays(5),
                        78,
                        30)
        );
        List<Food> result = stores.get(0).getFoodList();
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddToShopWithoutDiscount() {
        List<Store> stores = List.of(new Shop());
        List<Food> foods = List.of(
                new Food("milk",
                        LocalDate.now().plusDays(3),
                        LocalDate.now().minusDays(2),
                        50,
                        20),
                new Food("apple",
                        LocalDate.now().plusDays(10),
                        LocalDate.now().minusDays(5),
                        78,
                        30)
        );
        ControlQuality cq = new ControlQuality(stores);
        for (var food : foods) {
            cq.reallocate(food);
        }
        List<Food> expected = List.of(
                new Food("milk",
                        LocalDate.now().plusDays(3),
                        LocalDate.now().minusDays(2),
                        50,
                        20),
                new Food("apple",
                        LocalDate.now().plusDays(10),
                        LocalDate.now().minusDays(5),
                        78,
                        30)
        );
        List<Food> result = stores.get(0).getFoodList();
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddToShopWithDiscount() {
        List<Store> stores = List.of(new Shop());
        List<Food> foods = List.of(
                new Food("milk",
                        LocalDate.now().plusDays(3),
                        LocalDate.now().minusDays(10),
                        50,
                        20),
                new Food("apple",
                        LocalDate.now().plusDays(2),
                        LocalDate.now().minusDays(9),
                        80,
                        30)
        );
        ControlQuality cq = new ControlQuality(stores);
        for (var food : foods) {
            cq.reallocate(food);
        }
        List<Food> expected = List.of(
                new Food("milk",
                        LocalDate.now().plusDays(3),
                        LocalDate.now().minusDays(10),
                        40,
                        20),
                new Food("apple",
                        LocalDate.now().plusDays(2),
                        LocalDate.now().minusDays(9),
                        56,
                        30)
        );
        List<Food> result = stores.get(0).getFoodList();
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddToTrash() {
        List<Store> stores = List.of(new Trash());
        List<Food> foods = List.of(
                new Food("milk",
                        LocalDate.now(),
                        LocalDate.now().minusDays(10),
                        50,
                        20),
                new Food("apple",
                        LocalDate.now().minusDays(2),
                        LocalDate.now().minusDays(9),
                        80,
                        30)
        );
        ControlQuality cq = new ControlQuality(stores);
        for (var food : foods) {
            cq.reallocate(food);
        }
        List<Food> expected = List.of(
                new Food("milk",
                        LocalDate.now(),
                        LocalDate.now().minusDays(10),
                        50,
                        20),
                new Food("apple",
                        LocalDate.now().minusDays(2),
                        LocalDate.now().minusDays(9),
                        80,
                        30)
        );
        List<Food> result = stores.get(0).getFoodList();
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddAllStore() {
        List<Store> stores = List.of(new Warehouse(), new Shop(), new Trash());
        List<Food> foods = List.of(
                new Food("milk",
                        LocalDate.now().plusDays(3),
                        LocalDate.now().minusDays(3),
                        50,
                        20),
                new Food("apple",
                        LocalDate.now().plusDays(10),
                        LocalDate.now().minusDays(1),
                        78,
                        30),
                new Food("bread",
                        LocalDate.now(),
                        LocalDate.now().minusDays(5),
                        45,
                        10),
                new Food("meat",
                        LocalDate.now().plusDays(1),
                        LocalDate.now().minusDays(10),
                        150,
                        20)
        );
        ControlQuality cq = new ControlQuality(stores);
        for (var food : foods) {
            cq.reallocate(food);
        }
        assertThat(stores.get(0).getFoodList().get(0).getName(), is("apple"));
        assertThat(stores.get(1).getFoodList().get(0).getName(), is("milk"));
        assertThat(stores.get(1).getFoodList().get(1).getName(), is("meat"));
        assertThat(stores.get(2).getFoodList().get(0).getName(), is("bread"));
    }
}