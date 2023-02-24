package xyz.larkyy.amegtester;

import org.bukkit.Location;
import xyz.larkyy.aquaticmodelengine.api.AquaticModelEngineAPI;
import xyz.larkyy.aquaticmodelengine.api.model.spawned.SpawnedModel;

public class ModelsHandler {

    public SpawnedModel spawnModel(String name, Location location) {
        var holder = AquaticModelEngineAPI.getModelHandler().createDummyModelHolder(location);
        return AquaticModelEngineAPI.getModelHandler().spawnModel(holder,name);
    }

}
