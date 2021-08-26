package com.gt.service;

import com.gt.domains.Kingdom;

import java.util.List;
import java.util.Map;

public interface ElectionService {
    public boolean messageKingdom(String[] args);
    public void resetElections();
    public List<Kingdom> getWonKingdoms();
    public Map<String, Kingdom> getKingdoms();

}
