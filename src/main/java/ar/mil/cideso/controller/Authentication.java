/* private void ingresar() throws ClientProtocolException, IOException, JSONException, ValidacionErrorException {

		JSONObject object = this.solicitarListaDeApps();
		// 200 OK
		if (object.getInt("Result") == 200) {
			Map<String, SimpleEntry<String, String>> appsXUsuario = new HashMap<String, SimpleEntry<String, String>>();
			JSONArray array = object.getJSONArray("Aplicaciones");

			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				SimpleEntry<String, String> entry = new SimpleEntry<String, String>(obj.getString("id"),
						obj.getString("Version"));
				appsXUsuario.put(obj.getString("Nombre") + "-" + obj.getString("Version"), entry);
			}

			this.levantarVentanaValidar(appsXUsuario);

		} else {
			throw new ValidacionErrorException(object.getString("Mensaje"));
		}
	}

	private JSONObject solicitarListaDeApps() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost("http://" + this.getURLServidor() + "/api/ApiCredenciales/APPs");
		StringEntity params = new StringEntity("{\"ApiKey\": \"C1De5o202i\",\"Usuario\": \"" + usuarioText.getText()
				+ "\",  \"Password\": \"" + passwordText.getText() + "\"}");
		request.addHeader("content-type", "application/json");
		request.setEntity(params);
		HttpResponse response = httpClient.execute(request);
		String jsonString = EntityUtils.toString(response.getEntity());
		return new JSONObject(jsonString);
	} */