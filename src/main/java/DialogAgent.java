import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class DialogAgent {
    DataAgent dataAgent = new DataAgent();
    private Building building;
    private Trash trash;

    @PostMapping("/process-form")
    public void addBuilding(@RequestParam("buildingCode") int buildingCode, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("region") String region, @RequestParam("numApartments") int numApartments, Model model) {
        model.addAttribute("buildingCode", buildingCode);
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("region", region);
        model.addAttribute("numApartments", numApartments);
        dataAgent.addBuilding(buildingCode, name, address, region, numApartments);
    }

    @PostMapping("/process-form")
    public void addTrash(@RequestParam("trashCode") int trashCode, @RequestParam("type") String type, @RequestParam("maxCapacity") float maxCapacity, @RequestParam("currentCapacity") float currentCapacity, @RequestParam("buildingCode") int buildingCode, Model model) {
        model.addAttribute("trashCode", trashCode);
        model.addAttribute("type", type);
        model.addAttribute("maxCapacity", maxCapacity);
        model.addAttribute("currentCapacity", currentCapacity);
        model.addAttribute("buildingCode", buildingCode);
        building = dataAgent.getBuilding(buildingCode);
        if(building != null)
            dataAgent.addTrash(trashCode, type, maxCapacity, currentCapacity, buildingCode);
    }

    @PostMapping("/process-form")
    public Building getBuilding(@RequestParam("buildingCode") int buildingCode, Model model) {
        model.addAttribute("buildingCode", buildingCode);
        building = dataAgent.getBuilding(buildingCode);
        return building != null ? building : null;
    }

    @PostMapping("/process-form")
    public List<Trash> getTrashTypeList(@RequestParam("type") String type, Model model) {
        model.addAttribute("type", type);
        List<Trash> trashList = dataAgent.getTrashTypeList(type);
        return trashList.isEmpty() ? null : trashList;
    }


}
