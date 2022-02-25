package com.example.njshoppingservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// import java.util.Optional;
// import java.util.UUID;
import java.util.UUID;

import com.example.njshoppingservice.model.Summary;

import org.springframework.stereotype.Component;


@Component("fakeDao")
public class FakeSummaryDataAccessService implements SummaryDao {

    private static List<Summary> DB = new ArrayList<>();

    @Override
    public List<Summary> selectAllOrders() {
        // TODO Auto-generated method stub
        return DB;
    }

    @Override
    public int insertOrder(Summary summary) {
        DB.add(summary);
        return 1;
    }

    @Override
    public Optional<Summary> selectOrderById(UUID id) {
        // TODO Auto-generated method stub
        return DB.stream()
                    .filter(summary -> summary.getId().equals(id))
                    .findFirst();
    }

}

