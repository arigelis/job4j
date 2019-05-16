package ru.job4j.search;

import java.util.*;

public class Departments {
    public static final class Org implements Comparable<Org> {
        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public int compareTo(Org o) {
            return 0;
        }

        @Override
        public String toString() {
            return deps.toString();
        }
    }

    public List<Org> convert(List<String> deps) {
        List<Org> orgList = new ArrayList<>();
        for (int i = 0; i < deps.size(); i++) {
            String[] tmpDep = deps.get(i).split("/");
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < tmpDep.length; j++) {
                stringBuilder.append(tmpDep[j]);
                orgList.add(new Org(Arrays.asList(stringBuilder.toString())));
                if (j < tmpDep.length - 1) {
                    stringBuilder.append(", ");
                }
            }
        }
        return orgList;
    }

    public List<Org> sortAsc(List<Org> orgs) {
        Collections.sort(orgs, new Comparator<Org>() {
            @Override
            public int compare(Org o1, Org o2) {
                return o1.equals(o2) ? -1 : 0;
            }
        });
        return orgs;
    }

    public List<Org> sortDesc(List<Org> orgs) {
        Collections.sort(orgs, new Comparator<Org>() {
            @Override
            public int compare(Org o1, Org o2) {
                return o1.equals(o2) ? 0 : -1;
            }
        });
        return orgs;
    }
}
