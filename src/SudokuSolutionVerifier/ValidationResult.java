/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author M
 */
public class ValidationResult {
    private boolean valid;
    private Map<String, List<DuplicateValue>> duplicates;

    public ValidationResult() {
        this.valid = true;
        this.duplicates = new ConcurrentHashMap<>();
    }

    public ValidationResult(boolean valid, List<String> errors) {
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Map<String, List<DuplicateValue>> getDuplicates() {
        return duplicates;
    }
     public void addDuplicate(String key, DuplicateValue info) {
        duplicates.computeIfAbsent(key, k -> new ArrayList<>()).add(info);
        this.valid = false;
    }
    public void merge(ValidationResult o) {
        if (!o.isValid()) {
            this.valid = false;
        }
        o.getDuplicates().forEach((key, list) -> {
            duplicates.computeIfAbsent(key, k -> new ArrayList<>()).addAll(list);
        });
    }
}